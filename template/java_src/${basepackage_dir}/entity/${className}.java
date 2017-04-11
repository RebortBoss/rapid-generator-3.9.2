<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;

import com.thinkgem.jeesite.modules.base.persistence.ExDataEntity;
import java.util.Date;

public class ${className} extends ExDataEntity<${className}> {

	private static final long serialVersionUID = 1L;
	<#list table.columns as column>
	<@generateBycondition column.sqlName>
	
	private ${column.simpleJavaType} ${column.columnNameLower};
	</@generateBycondition>
	</#list>

<@generateJavaColumns/>
}
<#macro generateJavaColumns>
	<#list table.columns as column>
    <@generateBycondition column.sqlName>
	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	</@generateBycondition>
	</#list>
</#macro>