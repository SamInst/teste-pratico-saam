package component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import swing.ButtonOutLine;

public class PainelCobertura extends JPanel {
    private final DecimalFormat formatoDecimal = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener evento;
    private final MigLayout layout;
    private JLabel titulo;
    private JLabel descricao;
    private JLabel descricao1;
    private ButtonOutLine botao;
    private boolean estaLogin;

    public PainelCobertura() {
        iniciarComponentes();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        iniciar();
    }

    private void iniciar() {
        titulo = new JLabel("Bem-vindo de volta!");
        titulo.setFont(new Font("sansserif", 1, 30));
        titulo.setForeground(new Color(245, 245, 245));
        add(titulo);
        descricao = new JLabel("Para se manter conectado conosco");
        descricao.setForeground(new Color(245, 245, 245));
        add(descricao);
        descricao1 = new JLabel("faça login com suas informações pessoais");
        descricao1.setForeground(new Color(245, 245, 245));
        add(descricao1);
        botao = new ButtonOutLine();
        botao.setBackground(new Color(255, 255, 255));
        botao.setForeground(new Color(255, 255, 255));
        botao.setText("ENTRAR");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                evento.actionPerformed(ae);
            }
        });
        add(botao, "w 60%, h 40");
    }

    private void iniciarComponentes() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics graficos) {
        Graphics2D g2 = (Graphics2D) graficos;
        GradientPaint gradiente = new GradientPaint(0, 0, new Color(35, 166, 97), 0, getHeight(), new Color(22, 116, 66));
        g2.setPaint(gradiente);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graficos);
    }

    public void adicionarEvento(ActionListener evento) {
        this.evento = evento;
    }

    public void registrarEsquerda(double v) {
        v = Double.parseDouble(formatoDecimal.format(v));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao1, "pad 0 -" + v + "% 0 0");
    }

    public void registrarDireita(double v) {
        v = Double.parseDouble(formatoDecimal.format(v));
        login(false);
        layout.setComponentConstraints(titulo, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(descricao1, "pad 0 -" + v + "% 0 0");
    }

    public void loginEsquerda(double v) {
        v = Double.parseDouble(formatoDecimal.format(v));
        login(true);
        layout.setComponentConstraints(titulo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginDireita(double v) {
        v = Double.parseDouble(formatoDecimal.format(v));
        login(true);
        layout.setComponentConstraints(titulo, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(descricao1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void login(boolean login) {
        if (this.estaLogin != login) {
            if (login) {
                titulo.setText("Olá, amigo!");
                descricao.setText("Digite seus dados pessoais");
                descricao1.setText("e inicie sua jornada conosco");
                botao.setText("CADASTRAR");
            } else {
                titulo.setText("Bem-vindo de volta!");
                descricao.setText("Para se manter conectado conosco");
                descricao1.setText("faça login com suas informações pessoais");
                botao.setText("ENTRAR");
            }
            this.estaLogin = login;
        }
    }
}