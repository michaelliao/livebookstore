<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/">
        <html><head>
            <title>Spring_Xslt</title>
        </head>
        <body>
            <h3>Hello,
                <xsl:value-of select="DocRoot/name" />, it is
                <xsl:value-of select="DocRoot/time" /></h3>
        </body></html>
    </xsl:template>
</xsl:stylesheet>
