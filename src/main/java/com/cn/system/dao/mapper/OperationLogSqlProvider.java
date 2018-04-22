package com.cn.system.dao.mapper;

import com.cn.system.dao.model.OperationLog;
import com.cn.system.dao.model.OperationLogExample.Criteria;
import com.cn.system.dao.model.OperationLogExample.Criterion;
import com.cn.system.dao.model.OperationLogExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OperationLogSqlProvider {

    public String countByExample(OperationLogExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("operation_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OperationLogExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("operation_log");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OperationLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("operation_log");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }
        
        if (record.getOperationId() != null) {
            sql.VALUES("operation_id", "#{operationId,jdbcType=BIGINT}");
        }
        
        if (record.getOperationName() != null) {
            sql.VALUES("operation_name", "#{operationName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUrlName() != null) {
            sql.VALUES("url_name", "#{urlName,jdbcType=VARCHAR}");
        }
        
        if (record.getController() != null) {
            sql.VALUES("controller", "#{controller,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.VALUES("method", "#{method,jdbcType=VARCHAR}");
        }
        
        if (record.getParams() != null) {
            sql.VALUES("params", "#{params,jdbcType=VARCHAR}");
        }
        
        if (record.getCosttime() != null) {
            sql.VALUES("costTime", "#{costtime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OperationLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("url");
        sql.SELECT("ip");
        sql.SELECT("operation_id");
        sql.SELECT("operation_name");
        sql.SELECT("create_time");
        sql.SELECT("url_name");
        sql.SELECT("controller");
        sql.SELECT("method");
        sql.SELECT("params");
        sql.SELECT("costTime");
        sql.FROM("operation_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OperationLog record = (OperationLog) parameter.get("record");
        OperationLogExample example = (OperationLogExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("operation_log");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getIp() != null) {
            sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        }
        
        if (record.getOperationId() != null) {
            sql.SET("operation_id = #{record.operationId,jdbcType=BIGINT}");
        }
        
        if (record.getOperationName() != null) {
            sql.SET("operation_name = #{record.operationName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUrlName() != null) {
            sql.SET("url_name = #{record.urlName,jdbcType=VARCHAR}");
        }
        
        if (record.getController() != null) {
            sql.SET("controller = #{record.controller,jdbcType=VARCHAR}");
        }
        
        if (record.getMethod() != null) {
            sql.SET("method = #{record.method,jdbcType=VARCHAR}");
        }
        
        if (record.getParams() != null) {
            sql.SET("params = #{record.params,jdbcType=VARCHAR}");
        }
        
        if (record.getCosttime() != null) {
            sql.SET("costTime = #{record.costtime,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("operation_log");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("ip = #{record.ip,jdbcType=VARCHAR}");
        sql.SET("operation_id = #{record.operationId,jdbcType=BIGINT}");
        sql.SET("operation_name = #{record.operationName,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("url_name = #{record.urlName,jdbcType=VARCHAR}");
        sql.SET("controller = #{record.controller,jdbcType=VARCHAR}");
        sql.SET("method = #{record.method,jdbcType=VARCHAR}");
        sql.SET("params = #{record.params,jdbcType=VARCHAR}");
        sql.SET("costTime = #{record.costtime,jdbcType=VARCHAR}");
        
        OperationLogExample example = (OperationLogExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OperationLogExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}