package com.jelly.node.datastore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NaruMapper {
	final static String tableName = "allkeys";

	@Select("SELECT guid FROM " + tableName)
	List<String> loadAll();
	
	@Select("SELECT * FROM " + tableName + " WHERE guid = #{guid}")
	Naru getVal(@Param("guid") String guid);

	@Delete("DELETE FROM " + tableName + " WHERE guid = #{guid}")
	void delete(@Param("guid") String guid);

	@Update("UPDATE " + tableName + " SET val=#{val} WHERE guid=#{guid}")
	void update(@Param("guid") String guid, @Param("val") byte[] val);

	@Insert("INSERT INTO " + tableName + " VALUES (#{guid},#{val}) " + "ON DUPLICATE KEY UPDATE val=#{val}")
	void insert(@Param("guid") String guid, @Param("val") byte[] val);
}