package gwtquery.plugins.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;
import gwtquery.plugins.ui.resources.GWTQueryUIResources;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class GwtQueryUIPluginEntryPoint implements EntryPoint {

    private static HeadElement head;

    @Override
    public void onModuleLoad() {
        inject(GWTQueryUIResources.RESOURCES.jquery142min().getText());
        inject(GWTQueryUIResources.RESOURCES.jqueryui185min().getText());
    }

    /**
     * <p>
     * Create
     * {@code <script type="text/javascript" language="javascript">...</script>}
     * element in the Document Header. </p>
     *
     * @param javascript
     */
    public static void inject(String javascript) {
        assert (javascript != null && !javascript.equals("")) : "Javascript must not be null or Empty String";

        HeadElement head = getHead();
        ScriptElement element = createScriptElement();
        element.setText(javascript);
        head.appendChild(element);
    }

    public static void inject(String... javascripts) {
        assert javascripts != null : "The element passed must not be null";

        for (String javascript : javascripts) {
            inject(javascript);
        }
    }

    protected static HeadElement getHead() {
        if (head == null) {
            Element element = Document.get().getElementsByTagName("head").getItem(
                    0);
            assert element != null : "The host HTML page does not have a <head> element"
                    + " which is required by GPAbstractInjector";

            head = HeadElement.as(element);
        }

        return head;
    }

    protected static ScriptElement createScriptElement() {
        ScriptElement script = Document.get().createScriptElement();
        script.setAttribute(
                ScriptKeywordEnum.SCRIPT_LANGUAGE.getValue().getKey(),
                ScriptKeywordEnum.SCRIPT_LANGUAGE.getValue().getValue());
        script.setAttribute(
                ScriptKeywordEnum.SCRIPT_TYPE.getValue().getKey(),
                ScriptKeywordEnum.SCRIPT_TYPE.getValue().getValue());
        script.setAttribute(
                ScriptKeywordEnum.SCRIPT_CHARSET.getValue().getKey(),
                ScriptKeywordEnum.SCRIPT_CHARSET.getValue().getValue());
        return script;
    }

}
