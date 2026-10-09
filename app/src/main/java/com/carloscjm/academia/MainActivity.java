package com.carloscjm.academia;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Casca do app: uma única tela que abre o index.html embutido (assets).
 * Toda a interface e a lógica do treino ficam nesse HTML.
 */
public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle estadoSalvo) {
        super.onCreate(estadoSalvo);

        web = new WebView(this);
        web.setBackgroundColor(Color.BLACK);
        web.setOverScrollMode(View.OVER_SCROLL_NEVER);
        web.setVerticalScrollBarEnabled(false);

        WebSettings config = web.getSettings();
        config.setJavaScriptEnabled(true);
        config.setDomStorageEnabled(true);
        config.setTextZoom(100);

        SharedPreferences prefs = getSharedPreferences("academia", MODE_PRIVATE);
        web.addJavascriptInterface(new Armazenamento(prefs), "AndroidStore");

        setContentView(web);
        web.loadUrl("file:///android_asset/index.html");
    }

    /** Na tela "Ciclo", o botão voltar retorna para "Hoje"; em "Hoje", sai do app. */
    @Override
    public void onBackPressed() {
        if (web != null && web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /** Guarda o progresso no armazenamento do próprio aparelho. */
    public static final class Armazenamento {

        private final SharedPreferences prefs;

        Armazenamento(SharedPreferences prefs) {
            this.prefs = prefs;
        }

        @JavascriptInterface
        public String ler() {
            return prefs.getString("estado", "");
        }

        @JavascriptInterface
        public void gravar(String valor) {
            prefs.edit().putString("estado", valor).commit();
        }
    }
}
