package component;

import net.miginfocom.swing.MigLayout;
import swing.Button;
import swing.MyPasswordField;
import swing.MyTextField;

import javax.swing.*;
import java.awt.*;

public class PainelLoginERegistro extends javax.swing.JLayeredPane {
    private JPanel login;
    private JPanel registro;

    public PainelLoginERegistro() {
        iniciarComponentes();
        iniciarRegistro();
        iniciarLogin();
        login.setVisible(false);
        registro.setVisible(true);
    }

    private void iniciarRegistro() {
        registro.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel rotulo = new JLabel("Criar Conta");
        rotulo.setFont(new Font("sansserif", Font.BOLD, 30));
        rotulo.setForeground(new Color(7, 164, 121));
        registro.add(rotulo);

        MyTextField txtUsuario = new MyTextField();
        txtUsuario.setPrefixIcon(new ImageIcon(("/src/icon/usuario.png")));
        txtUsuario.setHint("Nome");
        registro.add(txtUsuario, "w 60%");

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon("src/icon/email.png"));
        txtEmail.setHint("Email");
        registro.add(txtEmail, "w 60%");

        MyPasswordField txtSenha = new MyPasswordField();
        txtSenha.setPrefixIcon(new ImageIcon("src/icon/senha.png"));
        txtSenha.setHint("Senha");
        registro.add(txtSenha, "w 60%");

        Button botao = new Button();
        botao.setBackground(new Color(7, 164, 121));
        botao.setForeground(new Color(250, 250, 250));
        botao.setText("CADASTRAR");

        registro.add(botao, "w 40%, h 40");
    }

    private void iniciarLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel rotulo = new JLabel("Entrar");
        rotulo.setFont(new Font("sansserif", Font.BOLD, 30));
        rotulo.setForeground(new Color(7, 164, 121));
        login.add(rotulo);

        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon("src/icon/email.png"));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");

        MyPasswordField txtSenha = new MyPasswordField();
        txtSenha.setPrefixIcon(new ImageIcon("src/icon/senha.png"));
        txtSenha.setHint("Senha");
        login.add(txtSenha, "w 60%");

        Button botao = new Button();
        botao.setBackground(new Color(7, 164, 121));
        botao.setForeground(new Color(250, 250, 250));
        botao.setText("ENTRAR");
        login.add(botao, "w 40%, h 40");
    }

    public void mostrarRegistro(boolean mostrar) {
        if (mostrar) {
            registro.setVisible(true);
            login.setVisible(false);
        } else {
            registro.setVisible(false);
            login.setVisible(true);
        }
    }

    private void iniciarComponentes() {
        login = new JPanel();
        registro = new JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new Color(255, 255, 255));

        GroupLayout loginLayout = new GroupLayout(login);
        login.setLayout(loginLayout);

        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        registro.setBackground(new Color(255, 255, 255));

        GroupLayout registroLayout = new GroupLayout(registro);
        registro.setLayout(registroLayout);
        registroLayout.setHorizontalGroup(
                registroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );

        registroLayout.setVerticalGroup(
                registroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(registro, "card2");
    }
}