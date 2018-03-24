<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>
    <xsl:template match="Right">
        <Role><xsl:apply-templates select="@*|node()" /></Role>
    </xsl:template>
    <xsl:template match="Rights">
        <Roles><xsl:apply-templates select="@*|node()" /></Roles>
    </xsl:template>
    <xsl:template match="rightId">
        <roleId><xsl:apply-templates select="@*|node()" /></roleId>
    </xsl:template>
    <xsl:template match="rightId">
        <xsl:copy-of select="."/>
        <usersByRoleId />
    </xsl:template>

</xsl:stylesheet>