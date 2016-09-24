/*
 * Copyright (C) 2016 Kleber Kruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package br.ufms.desafio.controller;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufms.desafio.app.DesafioApp;
import br.ufms.desafio.model.Escola;
import livroandroid.lib.utils.HttpHelper;

public class EscolaService {

    private static final String TAG = DesafioApp.class.getSimpleName();

    private static final String URL = "http://192.168.1.10:8080/desafio/escolas";

    public void add(Escola e) throws IOException {
        String url = URL;
        HttpHelper http = new HttpHelper();
        Map<String, String> params = new HashMap<>();
        params.put("nome", e.getNome());
        params.put("email", e.getEmail());
        params.put("usuario", e.getUsuario());
        params.put("senha", e.getSenha());
        http.doPost(url, params, "UTF-8");
    }

    /**
     * Faz a requisição HTTP, cria a lista de escolas e salva o JSON em arquivo.
     */
    public List<Escola> getAll(Context context) throws IOException {
        Log.d(TAG, "URL: " + URL);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(URL);
        List<Escola> escolas = parserJSON(context, json);
        return escolas;
    }

    private static List<Escola> parserJSON(Context context, String json) throws IOException {
        List<Escola> escolas = new ArrayList<Escola>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject obj = root.getJSONObject("escolas");
            JSONArray jsonEscolas = obj.getJSONArray("escola");
            // Insere cada escola na lista
            for (int i = 0; i < jsonEscolas.length(); i++) {
                JSONObject jsonEscola = jsonEscolas.getJSONObject(i);
                Escola e = new Escola();
                // Lê as informações de cada escola
                e.setCodigo(jsonEscola.getLong("codigo"));
                e.setNome(jsonEscola.optString("nome"));
                e.setEmail(jsonEscola.optString("email"));
                e.setUsuario(jsonEscola.optString("usuario"));
                e.setSenha(jsonEscola.optString("senha"));
//                e.setTipo(jsonEscola.optString("tipo"));
//                e.setDataCriacao(jsonEscola.optString("criacao"));
//                e.setProfessores(jsonEscola.getJSONArray("professores"));
//                e.setAlunos(jsonEscola.getJSONArray("alunos"));
//                e.setTurmas(jsonEscola.getJSONArray("turmas"));
                escolas.add(e);
            }
        } catch (JSONException e) {
            throw new IOException(e.getMessage(), e);
        }
        return escolas;
    }
}
