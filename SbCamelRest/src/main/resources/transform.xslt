<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <goodbye>
      <xsl:value-of select="/hello"/>
    </goodbye>
  </xsl:template>

</xsl:stylesheet>