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

package br.ufms.desafio.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.Date;

import br.ufms.desafio.model.Aluno;
import br.ufms.desafio.model.Escola;
import br.ufms.desafio.model.Professor;
import br.ufms.desafio.model.Responsavel;
import br.ufms.desafio.model.TipoEscola;
import br.ufms.desafio.model.Titulacao;

public class DesafioApp extends Application {

    private static final String TAG = DesafioApp.class.getSimpleName();

    private static DesafioApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        Aluno a = new Aluno();
        a.setNome("");
        a.setEmail("");
        a.setEmailResponsavel("");
        a.setUsuario("");
        a.setSenha("");
        a.setDataNascimento(new Date());
        a.setTelefone("");
        a.setSerie(0);
        a.setEscola(new Escola());
//        a.setEndereco(new Endereco()); // depois preenche...
//        a.setDataInicio();
//        a.setDeficiente();
//        a.setDeficiencias();

        Professor p = new Professor();
        p.setNome("");
        p.setEmail("");
        p.setUsuario("");
        p.setSenha("");
        p.setDataNascimento(new Date());
        p.setTelefone("");
        p.setEscolas(new ArrayList<Escola>());
        p.setTitulacao(Titulacao.MESTRE);
//        p.setEndereco(new Endereco());

        Responsavel r = new Responsavel();
        r.setNome("");
        r.setEmail("");
        r.setUsuario("");
        r.setSenha("");
        r.setDataNascimento(new Date());
        r.setTelefone("");
        r.setCpf("");
//        r.setEndereco(new Endereco());

        Escola e = new Escola();
        e.setNome("");
        e.setEmail("");
        e.setUsuario("");
        e.setSenha("");
        e.setTipo(TipoEscola.ESTADUAL);
//        e.setEndereco();
        e.setTelefone("");

        // Nome
        // Nome de usuário
        // Data de nascimento (ou tipo da escola)
        // Email (do jogador ou responsável)
        // Senha
        // Confirme sua senha
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static DesafioApp getInstance() {
        return instance;
    }
}
