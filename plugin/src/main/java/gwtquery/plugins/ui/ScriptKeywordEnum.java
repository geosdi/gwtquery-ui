package gwtquery.plugins.ui;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public enum ScriptKeywordEnum {

    SCRIPT_TYPE(new ScriptKeyword("type", "text/javascript")),
    SCRIPT_LANGUAGE(new ScriptKeyword("language", "javascript")),
    SCRIPT_CHARSET(new ScriptKeyword("charset", "UTF-8"));
    private ScriptKeyword value;

    ScriptKeywordEnum(ScriptKeyword theValue) {
        this.value = theValue;
    }

    /**
     * @return the value
     */
    public ScriptKeyword getValue() {
        return value;
    }
}
