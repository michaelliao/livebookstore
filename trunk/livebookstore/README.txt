所有Java源代码的默认字符编码为UTF-8，请在Eclipse或其他IDE工具中修改默认的字符编码为UTF-8，否则为乱码。

目前支持两种数据库：HSQLDB和MySQL5

Windows平台默认采用HSQLDB数据库，Linux平台默认采用MySQL5数据库，
如果需要修改数据库设置，请根据平台修改/conf/linux/jdbc.properties或/conf/windows/jdbc.properties

执行命令ant deploy-linux或ant deploy-windows将生成可直接部署的deploy目录。

执行命令ant make-war将生成可直接部署的livebookstore.war文件，该文件即是deploy目录的所有内容。

需要注意：在某些Web服务器上，WAR文件不会被解压，因此，应用程序无法创建必要的目录，导致初始化失败。此时，需要将整个deploy目录复制到Web服务器的相应目录下。
