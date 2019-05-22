use peiyou;
SET autocommit=0;
######################################################################## 学生信息表(py_students) start #############################################################
# 退款订单中 增加 要退课的课次记录
UPDATE 
  peiyou.py_order_refund e,
  (SELECT 
    a.id AS id,
    GROUP_CONCAT(DISTINCT d.id) AS refund_course_id 
  FROM
    peiyou.py_order_refund a 
    JOIN education.quit_class b 
      ON a.refund_code = b.quit_sn 
    JOIN education.quit_class_c c 
      ON c.qc_id = b.id 
    JOIN peiyou.py_order_course d 
      ON d.tmp_old_id = c.osc_id 
  WHERE a.tmp_flag = 1 
  GROUP BY a.id) b 
SET
  e.refund_course_id = b.refund_course_id 
WHERE e.id = b.id;
######################################################################## 学生信息表(py_students) end ##############################################################

######################################################################## 订单退款表(py_order_refund) start ##############################################################

# 更新订单详情id
UPDATE 
  peiyou.py_order_refund ee,
  (SELECT 
    f.id AS nid,
    f.order_detail_id,
    a.id,
    a.tmp_order_detail_id 
  FROM
    peiyou.py_order_refund f 
    LEFT JOIN peiyou.py_order_detail a 
      ON f.order_detail_id = a.tmp_order_detail_id 
  WHERE f.tmp_flag = 1 
    AND f.order_detail_id IS NOT NULL) gg 
SET
  ee.order_detail_id = gg.id 
WHERE ee.id = gg.nid ;


# 更新用户编号
UPDATE  peiyou.py_order_refund ee,
(SELECT
  f.id AS refundId,
  f.user_id AS reUserId,
  g.id AS detailId,
  g.user_id  AS userId
FROM
  peiyou.py_order_refund f
  LEFT JOIN peiyou.py_order_detail g
    ON f.order_detail_id = g.id
WHERE f.tmp_flag = 1 ) gg
 SET ee.user_id = gg.userId
 WHERE ee.id = gg.refundId;



# 更新支付方式										
UPDATE 
  peiyou.py_order_refund ee,
  (SELECT 
    a.id,
    a.refund_method,
    c.payment_type 
  FROM
    peiyou.py_order_refund a 
    LEFT JOIN peiyou.py_order_detail b 
      ON a.order_detail_id = b.id 
    LEFT JOIN peiyou.py_orders c 
      ON b.order_code = c.order_code 
  WHERE a.tmp_flag = 1
    AND c.payment_type < 3) gg 
SET
  ee.refund_method = gg.payment_type 
WHERE ee.id = gg.id ;

# 更新支付方式										
UPDATE 
  peiyou.py_order_refund ee,
  (SELECT 
    a.id,
    a.refund_method,
    c.payment_type 
  FROM
    peiyou.py_order_refund a 
    LEFT JOIN peiyou.py_order_detail b 
      ON a.order_detail_id = b.id 
    LEFT JOIN peiyou.py_orders c 
      ON b.order_code = c.order_code 
  WHERE a.tmp_flag = 1
    AND c.payment_type >= 3) gg 
SET
  ee.refund_method = 3 
WHERE ee.id = gg.id ;
######################################################################## 订单退款表(py_order_refund) end ##############################################################

######################################################################## 课程表(py_order_course) start ##############################################################
UPDATE py_order_course e, (SELECT DISTINCT a.id AS id
 FROM peiyou.py_order_course a
 JOIN  education.quit_class_c b  ON a.tmp_old_id = b.osc_id
 WHERE a.tmp_flag = 1 ) f
SET e.refund_status = 1 WHERE e.id = f.id;
######################################################################## 课程表(py_order_course) end ##############################################################

COMMIT;