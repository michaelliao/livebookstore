安装指南 livebookstore 1.1 2007-9-8

--------------------
系统需求
--------------------
JDK 1.5.0_x版本（注意：1.6版本未测试）
MySQL 5.0.x版本
Resin 3.1.2版本
Ant 1.6.5或更高版本

已更新的组件：
Spring 2.0.6
Acegi 1.0.4

--------------------
安装MySQL 5
--------------------
安装MySQL 5服务器（默认编码为UTF8，默认数据库表为INNODB）
建立数据库bookstore
建立用户bookstore，口令livebookstore
（注意：如果用户名和口令与上述不符，请修改resin.conf文件的<database>配置）
确保用户bookstore有对数据库bookstore的select，insert，update和delete操作权限
初始化表：导入/db/mysql5/backup.sql

--------------------
设定配置
--------------------
请在/conf/smtp.properties中设定SMTP服务器信息

数据源已由原来直接通过Spring配置（/conf/services.xml）改为由服务器管理的JNDI数据源：
<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <property name="jndiName" value="java:comp/env/jdbc/bookstore" />
</bean>

请在/conf/log4j.properties中设定log文件地址，默认是/var/log/resin/livebookstore.log

编译后的Class文件将存放在/bin目录，Ant脚本会直接将编译好的所有Class文件打包放入/web/WEB-INF/lib/bookstore.jar，因此，/WEB-INF目录下不再需要/classes目录。

通过HTML访问JMX的HTML Adaptor默认没有启用，要启用HTML Adaptor，请将/conf/services.xml的相关注释去掉。

Velocity的缓存时间是3600秒，因此，运行期修改页面后可能无法立刻更新。要取消Cache，请设定/conf/velocity.properties：
file.resource.loader.cache = false
file.resource.loader.modificationCheckInterval = 0
velocimacro.library.autoreload = true

请在Dreamwaver中自行删除模板文件中的Google广告，然后更新所有HTML页面

--------------------
编译工程
--------------------
运行默认的Ant任务ant_build.bat，将在/web目录下获得完整的应用程序

第一次运行时，请重建所有书籍索引，否则将搜索不到任何书籍

--------------------
Bug修复
--------------------
net.livebookstore.web.core.AbstractScriptController:
JavaScript的MIME类型更正为application/x-javascript
Cache-Control头更正为max-age=xxx
