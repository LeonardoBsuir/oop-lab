<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>
    <xsl:template match="Role">
        <Right><xsl:apply-templates select="@*|node()" /></Right>
    </xsl:template>
    <xsl:template match="Roles">
        <Rights><xsl:apply-templates select="@*|node()" /></Rights>
    </xsl:template>
    <xsl:template match="roleId">
        <rightId><xsl:apply-templates select="@*|node()" /></rightId>
    </xsl:template>
    <xsl:template match="usersByRoleId">
    </xsl:template>

</xsl:stylesheet>