package com.grupoFiapo.fintech;

import com.grupoFiapo.fintech.models.RegistroLogin;

public class TestRegistroLogin {
    public static void main(String[] args) {
        // Registra o usuário
        RegistroLogin.registrarUsuario();

        // Realiza o login (pode ser chamado após o registro ou em outro fluxo)
        RegistroLogin.realizarLogin();
    }
}
