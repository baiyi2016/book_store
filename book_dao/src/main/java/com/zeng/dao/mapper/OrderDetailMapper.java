package com.zeng.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.zeng.dao.entity.OrderDetail;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface OrderDetailMapper {

	void insertOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetailById(Integer id);

	void updateOrderDetail(OrderDetail orderDetail);

	Page<OrderDetail> searchOrderDetailByParams(@Param("map")Map<String, String> map , Pageable pageable);

	List<OrderDetail> searchOrderDetailByParams(@Param("map")Map<String, String> map);

} 
