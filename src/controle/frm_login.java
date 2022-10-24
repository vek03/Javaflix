package controle;

//imports necessários
import user.frm_catalogo;
import admin.frm_selection_mode;
import conexao.Conexao;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JOptionPane; 
import javax.swing.ImageIcon;

/**
 *
 * @author Victor e Mariane
 * Mari Vek Histories
 */

public class frm_login extends javax.swing.JFrame 
{
    //criando objeto conexão
    Conexao con_cliente;

    //método construtor
    public frm_login() 
    {
        initComponents(); //iniciando componentes
        con_cliente = new Conexao(); //instanciando classe conexão
        con_cliente.conecta(); //conectando ao servidor
        btn_login.setBackground(Color.RED); //colorindo botão
        lblCadastro.setText("<html><u>Cadastre-se aqui!</u></html>"); //decorando label
        logo(); //chamando o método para inserir logo
        icone(); //chamando o método para inserir ícone
        getRootPane().setDefaultButton(btn_login);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        alert = new javax.swing.JLabel();
        radioAdmin = new javax.swing.JRadioButton();
        radioUser = new javax.swing.JRadioButton();
        lblCadastro = new javax.swing.JLabel();
        descriCadastro = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        lbl_password1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Javaflix(Login)");
        setBackground(new java.awt.Color(153, 0, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        lbl_title.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Acesso ao Sistema");

        lbl_user.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("Usuário:");

        lbl_password.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Senha:");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUser.setToolTipText("Insira seu usuário");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSenha.setToolTipText("Insira sua senha");

        btn_login.setBackground(new java.awt.Color(255, 0, 0));
        btn_login.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Acessar");
        btn_login.setToolTipText("Acessar sua conta");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        alert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 0));
        alert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        radioAdmin.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(radioAdmin);
        radioAdmin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioAdmin.setForeground(new java.awt.Color(255, 255, 255));
        radioAdmin.setText("Administrador");
        radioAdmin.setToolTipText("Apenas para funcionários");
        radioAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        radioUser.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(radioUser);
        radioUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        radioUser.setForeground(new java.awt.Color(255, 255, 255));
        radioUser.setSelected(true);
        radioUser.setText("Usuário");
        radioUser.setToolTipText("Para clientes");
        radioUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCadastro.setForeground(new java.awt.Color(255, 255, 255));
        lblCadastro.setText("Cadastre-se!");
        lblCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCadastroMouseExited(evt);
            }
        });

        descriCadastro.setForeground(new java.awt.Color(255, 255, 255));
        descriCadastro.setText("Não tem uma conta?");

        lbl_password1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_password1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password1.setText("Você é um:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_user)
                            .addComponent(lbl_password)
                            .addComponent(lbl_password1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioUser))
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btn_login)))
                .addGap(0, 129, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(descriCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCadastro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(lbl_title)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_title)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadastro)
                    .addComponent(descriCadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_user)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_password))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAdmin)
                    .addComponent(radioUser)
                    .addComponent(lbl_password1))
                .addGap(34, 34, 34)
                .addComponent(btn_login)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //método que insere o logo 
    private void logo(){
        //classe que traz a imagem na raiz do projeto
        //classe getClass e getResourse são para puxar a imagem no arquivo .jar 
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icones/javaflix.png"));
        //classe que redimensiona a imagem
        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 50,Image.SCALE_DEFAULT);
        //classe que traz a imagem dimensionada
        ImageIcon img = new ImageIcon(scaleImage);
        
        //setando logo
        logo.setIcon(img);
    }
    
    //método que insere ícone no programa
    private void icone(){
        //classe que traz a imagem na raiz do projeto
        //função getClass e getResourse são para puxar a imagem no arquivo .jar 
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icones/icon.png"));
        //classe que redimensiona a imagem
        Image scaleImage = imageIcon.getImage().getScaledInstance(45, 45,Image.SCALE_DEFAULT);
        //classe que traz a imagem dimensionada
        ImageIcon img = new ImageIcon(scaleImage);
        
        //setando icone
        this.setIconImage(img.getImage());
    }
    
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        //este botão irá realizar o login do usuário
        
        //verificando tipo de usuário admin
        if(radioAdmin.isSelected()){
            //tratamento de campos vazios
            if(txtUser.getText().length() > 0 && txtSenha.getText().length() > 0){
                try{
                    //verificando usuario e senha
                    String pesquisa = "select * from admin where usuario = '" + txtUser.getText() + "' && senha = " + txtSenha.getText() + "";
                    con_cliente.executaSQL(pesquisa);

                    //entrando na visão de admin
                    if (con_cliente.resultset.first())
                    {
                        con_cliente.executaSQL(pesquisa);
                        con_cliente.resultset.first();
                        //enviando dados do admin para a próxima pagina
                        int realId = con_cliente.resultset.getInt("id");
                        String realUser = con_cliente.resultset.getString("usuario");
                        String realNome = con_cliente.resultset.getString("nome");
                        //chamando próxima página
                        frm_selection_mode mostra = new frm_selection_mode(realId, realUser, realNome);
                        mostra.setVisible(true);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "\n Usuário ou senha estão incorretos!\n Tente novamente","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                        txtUser.requestFocus();
                    }

                }
                catch(SQLException errosql){
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    txtUser.requestFocus();
                }
            }else{
                alert.setText("Preencha os campos!");
                txtUser.requestFocus();
            }
        
        //verificando tipo de usuario cliente
        }else{
            //tratamento dos campos vazios
            if(txtUser.getText().length() > 0 && txtSenha.getText().length() > 0){
                try{
                    //verificando usuario e senha
                    String pesquisa = "select * from usuarios where usuario = '" + txtUser.getText() + "' && senha = " + txtSenha.getText() + "";
                    con_cliente.executaSQL(pesquisa);

                    //entrando na visão de cliente
                    if (con_cliente.resultset.first())
                    {
                        con_cliente.executaSQL(pesquisa);
                        con_cliente.resultset.first();
                        //enviando dados do cliente para a proxima pagina
                        int realId = con_cliente.resultset.getInt("id");
                        String realUser = con_cliente.resultset.getString("usuario");
                        String realNome = con_cliente.resultset.getString("nome");
                        String realNasc = con_cliente.resultset.getString("data_nasc");
                        //abrindo nova janela
                        frm_catalogo mostra = new frm_catalogo(realId, realUser, realNome, realNasc);
                        mostra.setVisible(true);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "\n Usuário e/ou senha estão incorretos!\n Tente novamente","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                        txtUser.requestFocus();
                    }

                }
                catch(SQLException errosql){
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados!! :\n ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    txtUser.requestFocus();
                }
            }else{
                alert.setText("Preencha os campos!");
                txtUser.requestFocus();
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void lblCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseClicked
        //quando o usuário clicar na label "cadastre-se", ele será redirecionado para o cadastro
        
        //abrindo janela cadastro
        frm_cadastro mostra = new frm_cadastro();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblCadastroMouseClicked

    private void lblCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseEntered
        //quando o mouse estiver sobre a label "cadastre-se" ela ficará decorada
        
        lblCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCadastro.setFont(new java.awt.Font("Tahoma", 1, 11));
    }//GEN-LAST:event_lblCadastroMouseEntered

    private void lblCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCadastroMouseExited
        //quando o mouse não estiver mais sobre a label "cadastre-se", ela voltará ao normal
        
        lblCadastro.setFont(new java.awt.Font("Tahoma", 0, 12));
    }//GEN-LAST:event_lblCadastroMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert;
    private javax.swing.JButton btn_login;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel descriCadastro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_password1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JLabel logo;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioUser;
    private javax.swing.JPasswordField txtSenha;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
