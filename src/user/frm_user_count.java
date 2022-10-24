package user;

//imports necessários
import conexao.Conexao;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor e Mariane
 * Mari Vek Histories
 */

public class frm_user_count extends javax.swing.JFrame {

    //declarando variavel para a classe Conexão
    Conexao con_cliente;
    
    //declarando variaveis para passagem dos dados do usuário entre classes
    private int id;
    private String usuario;
    private String nome;
    private String nasc;
    
    /**
     * Creates new form frm_user_count
     */
    public frm_user_count(int realId, String realUser, String realNome, String realNasc) {
        initComponents(); //iniciando componentes do JFrame
        //chamando método que inicia as variaveis do parametro
        initVariables(realId, realUser, realNome, realNasc);
        con_cliente = new Conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        //enviando instrução SQL para selecionar o registro usuário
        con_cliente.executaSQL("select * from usuarios where `id` = " + realId);
        posicionarRegistro(); //posicionar resultset no primeiro registro
        icone(); //metodo que seta o icone do programa
        logo(); //metodo que seta a logo do programa
    }
    
    //método que inicia as variaveis passadas pelo parametro
    private void initVariables(int realId, String realUser, String realNome, String realNasc){
        id = realId;
        usuario = realUser;
        nome = realNome;
        nasc = realNasc;
    }

    //metodo que define o icone do programa
    private void icone(){
        //método que traz a imagem na raiz do projeto
        //método getClass e getResourse são para puxar a imagem no arquivo .jar 
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icones/icon.png"));
        //método que redimensiona a imagem
        Image scaleImage = imageIcon.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        //método que traz a imagem dimensionada
        ImageIcon img = new ImageIcon(scaleImage);
        
        this.setIconImage(img.getImage());
    }
    
    //metodo que define a logo do programa
    private void logo(){
        //método que traz a imagem na raiz do projeto
        //método getClass e getResourse são para puxar a imagem no arquivo .jar 
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icones/javaflix.png"));
        //método que redimensiona a imagem
        Image scaleImage = imageIcon.getImage().getScaledInstance(100, 50,Image.SCALE_DEFAULT);
        //método que traz a imagem dimensionada
        ImageIcon img = new ImageIcon(scaleImage);
        
        logo.setIcon(img);
    }
    
    //método que irá mostrar os dados do registro selecionado
    private void mostrarDados(){
        try 
        {
            txtId.setText(id + "");
            txtNome.setText(nome);
            txtEndereco.setText(con_cliente.resultset.getString("endereco"));
            txtTel.setValue(con_cliente.resultset.getString("telefone"));
            txtUser.setText(usuario);
            txtSenha.setText(con_cliente.resultset.getString("senha"));
            
            DateTimeFormatter formatSql = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatBra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data_devolucao = LocalDate.parse(con_cliente.resultset.getString("data_nasc"), formatSql);
            txtNasc.setValue(data_devolucao.format(formatBra));
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não localizou dados: ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //metodo que posiciona o resultset no 1° registro e mostra os dados
    private void posicionarRegistro(){
        try {
            con_cliente.resultset.first();
            mostrarDados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro:","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //método que atualiza os dados do usuário
    private void update(){
        //adicionando os valores dos campos as variaveis
        String endereco = txtEndereco.getText();
        String telefone = txtTel.getText();
        String senha = txtSenha.getText();
        
        //criando variavel de interação com o banco e a de mensagem de aviso
        String sql = "";
        String msg = "";

        //inserindo o novo registro ao banco
        try {
            //UPDATE
            //enviando instrução SQL para atualizar os dados
            sql="update usuarios set endereco='" + endereco + "', telefone='" + telefone + "', senha='" + senha + "' where id = " + txtId.getText();
            msg="Alteração de registro";
            
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

        }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro no cadastro :\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblNasc = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtNasc = new javax.swing.JFormattedTextField();
        txtTel = new javax.swing.JFormattedTextField();
        btnReturn = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        alert = new javax.swing.JLabel();
        aviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Javaflix(Minha Conta)");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(227, 4, 25));
        title.setText("Minha Conta");

        lblCod.setForeground(new java.awt.Color(255, 255, 255));
        lblCod.setText("ID:");

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        lblNasc.setForeground(new java.awt.Color(255, 255, 255));
        lblNasc.setText("Nascimento:");

        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setText("Endereço:*");

        lblTel.setForeground(new java.awt.Color(255, 255, 255));
        lblTel.setText("Telefone:*");

        lbluser.setForeground(new java.awt.Color(255, 255, 255));
        lbluser.setText("Usuário");

        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha:*");

        txtId.setEditable(false);
        txtId.setToolTipText("Seu ID");

        txtNome.setEditable(false);
        txtNome.setToolTipText("Seu nome");

        txtEndereco.setToolTipText("Atualize seu endereço");

        txtUser.setEditable(false);
        txtUser.setToolTipText("Seu usuário");

        txtSenha.setToolTipText("Redefina sua senha");

        txtNasc.setEditable(false);
        try {
            txtNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNasc.setToolTipText("Sua data de nascimento");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTel.setToolTipText("Atualize seu telefone");

        btnReturn.setBackground(new java.awt.Color(255, 255, 255));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset/door_in.png"))); // NOI18N
        btnReturn.setToolTipText("Retornar para o Catálogo de Filmes");
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.setMaximumSize(new java.awt.Dimension(55, 25));
        btnReturn.setPreferredSize(new java.awt.Dimension(55, 30));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setForeground(new java.awt.Color(227, 4, 25));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset/application_edit.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar Informações");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        alert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 51));

        aviso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        aviso.setForeground(new java.awt.Color(255, 0, 51));
        aviso.setText("Somente os campos com * podem ser alterados pelo usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(title))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEndereco)
                                            .addComponent(lblSenha)
                                            .addComponent(lblTel)
                                            .addComponent(lblNasc))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(4, 4, Short.MAX_VALUE)
                                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCod, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbluser, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(aviso)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCod)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNasc)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTel)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSenha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
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

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        //botão que retorna para o catalogo
        frm_catalogo mostra = new frm_catalogo(id, usuario, nome, nasc);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //este botão irá alterar um ou mais campos de um registro já existente selecionado pelo usuário
        //UPDATE

        //criando variavel de interação com o banco e a de mensagem de aviso
        String sql = "";
        String msg = "";

        //verificando se os campos foram preenchidos
        if(txtTel.getValue() != null && txtEndereco.getText().length() > 0
            && txtSenha.getText().length() > 0){
            try{
                //verificando se a senha contém apenas numeros
                long teste;
                teste =  Long.parseLong(txtSenha.getText());

                //verifica se a senha tem de 4 a 8 digitos
                if(txtSenha.getText().length() < 4 || txtSenha.getText().length() > 8){
                    JOptionPane.showMessageDialog(null, "A senha deve ter de 4 a 8 digitos!\n\nTente novamente!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    //atualizando registro e restartando instrução SQL construtora
                    update();
                    alert.setText(null);
                    con_cliente.executaSQL("select * from usuarios where `id` = " + id);
                    posicionarRegistro();
                }
 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "A senha só pode conter números!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
            }

        }else{
            alert.setText("Preencha os campos!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert;
    private javax.swing.JLabel aviso;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnReturn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
