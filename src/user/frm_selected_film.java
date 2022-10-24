package user;

//imports necessários
import conexao.Conexao;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor e Mariane.
 * Mari Vek Histories
 */

public class frm_selected_film extends javax.swing.JFrame {

    //declarando variavel para classe Conexão
    Conexao con_cliente;
    
    //variáveis para passagem de dados do usuário e do filme entre as classes
    private int id_user;
    private int id_film;
    private String url;
    private String nome;
    private String usuario;
    private String nasc;
    private String descricao;
    private String data_atual;
    private String data_devol;
    private String data_devol_sql;
    private long idade;
    
    /**
     * Creates new form frm_selected_film
     */
    //método construtor
    public frm_selected_film(int realId_user, int realId_film, String realURL, String realUser, String realNome, String realNasc, String realDesc) {
        initComponents(); //iniciando componentes do JFrame
        //chamando método de inicialização das variaveis do parametro
        initVariables(realId_user, realId_film, realURL, realUser, realNome, realNasc, realDesc);
        data(); //chamando método para trazer a data
        icone(); //chamando método para setar icone
        con_cliente = new Conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        //iniciando instrução SQL construtora para trazer o filme selecionado
        con_cliente.executaSQL("select * from filmes where `id` = " + realId_film);
        posicionarRegistro(); //posicionando resultset no registro do filme
    }
    
    //método que seta o ícone
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
    
    //método que inicia as variaveis do parametro
    private void initVariables(int realId_user, int realId_film, String realURL, String realUser, String realNome, String realNasc, String realDesc){
        id_user = realId_user;
        nome = realNome;
        usuario = realUser;
        nasc = realNasc;
        id_film = realId_film;
        url = realURL;
        descricao = realDesc;
        
        imgFilm.setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
    }

    
    //método que irá posicionar o resultset no primeiro registro
    private void posicionarRegistro(){
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro:"+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //método que exibe os dados do filme selecionado
    private void mostrar_Dados(){
        try {
            titulo.setText(con_cliente.resultset.getString("titulo"));
            title.setText(con_cliente.resultset.getString("titulo"));
            genero.setText(con_cliente.resultset.getString("genero"));
            classif.setText(con_cliente.resultset.getString("classificacao"));
            lancamento.setText(con_cliente.resultset.getString("lancamento"));
            duracao.setText(con_cliente.resultset.getString("duracao"));
            valor.setText(con_cliente.resultset.getString("valor"));
            desc.setText(descricao);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não localizou dados: ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //método que trás a data de devolução e a atual
    private void data(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatBra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatSql = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dt_nasc = LocalDate.parse(nasc, formatSql);
        
        idade = ChronoUnit.YEARS.between(dt_nasc, date);
        data_atual = date.format(formatSql);
        data_devol = date.plusDays(15).format(formatBra);
        data_devol_sql = date.plusDays(15).format(formatSql);
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
        imgFilm = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblGenero1 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblLanc = new javax.swing.JLabel();
        lblDur = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        lancamento = new javax.swing.JLabel();
        duracao = new javax.swing.JLabel();
        valor = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        btnAlugar = new javax.swing.JButton();
        cboPagamento = new javax.swing.JComboBox<>();
        lblpag = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblClass = new javax.swing.JLabel();
        classif = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Javaflix(Filme Selecionado)");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        imgFilm.setToolTipText("Capa do Filme");
        imgFilm.setMaximumSize(new java.awt.Dimension(155, 250));
        imgFilm.setMinimumSize(new java.awt.Dimension(155, 250));
        imgFilm.setPreferredSize(new java.awt.Dimension(155, 250));

        title.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("null");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Título:");

        lblGenero1.setForeground(new java.awt.Color(255, 255, 255));

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Gênero:");

        lblLanc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLanc.setForeground(new java.awt.Color(255, 255, 255));
        lblLanc.setText("Lançamento:");

        lblDur.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDur.setForeground(new java.awt.Color(255, 255, 255));
        lblDur.setText("Duração:");

        lblValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText("Valor: R$");

        titulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("null");

        genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        genero.setForeground(new java.awt.Color(255, 255, 255));
        genero.setText("null");

        lancamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lancamento.setForeground(new java.awt.Color(255, 255, 255));
        lancamento.setText("null");

        duracao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        duracao.setForeground(new java.awt.Color(255, 255, 255));
        duracao.setText("null");

        valor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valor.setForeground(new java.awt.Color(255, 255, 255));
        valor.setText("null");
        valor.setToolTipText("Valor do Filme(unitário)");

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("Descrição: ");

        desc.setEditable(false);
        desc.setBackground(new java.awt.Color(0, 51, 51));
        desc.setColumns(20);
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setRows(5);
        desc.setText("null");
        desc.setToolTipText("Descrição do Filme");
        desc.setMinimumSize(new java.awt.Dimension(74, 18));
        jScrollPane2.setViewportView(desc);

        btnAlugar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset/add.png"))); // NOI18N
        btnAlugar.setText("Alugar");
        btnAlugar.setToolTipText("Alugar Este Filme");
        btnAlugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Credito", "Debito", "Pix", "Dinheiro", "Boleto" }));
        cboPagamento.setToolTipText("Selecione a forma de pagamento");

        lblpag.setForeground(new java.awt.Color(255, 255, 255));
        lblpag.setText("Forma de Pagamento:");

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset/door_in.png"))); // NOI18N
        btnExit.setToolTipText("Retornar ao Catálogo");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblClass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClass.setForeground(new java.awt.Color(255, 255, 255));
        lblClass.setText("Faixa Etária:");

        classif.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        classif.setForeground(new java.awt.Color(255, 255, 255));
        classif.setText("null");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDur)
                                            .addComponent(lblValor))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valor)
                                            .addComponent(duracao)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblLanc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lancamento))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblGenero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(genero))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblClass)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(classif))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblTitulo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(titulo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblGenero1)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDesc)
                                    .addComponent(btnExit))
                                .addGap(95, 95, 95)
                                .addComponent(lblpag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(lblGenero1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTitulo)
                                    .addComponent(titulo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGenero)
                                    .addComponent(genero))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblClass)
                                    .addComponent(classif))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLanc)
                                    .addComponent(lancamento))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDur)
                                    .addComponent(duracao))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblValor)
                                    .addComponent(valor)))))
                    .addComponent(imgFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpag)
                        .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //quando a janela for fechada, o catalogo será aberto
        frm_catalogo mostra = new frm_catalogo(id_user, usuario, nome, nasc);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosed

    //método que insere a nova locação no banco
    private void insert(){
            //inserindo o novo registro ao banco
            try {
                //enviando instrução SQL e confirmando
                String insert_sql="insert into locacao  (`id_usuario`, `id_filme`, `usuario`, `filme`, `data_locacao`, `data_devolucao`, `form_pagamento`, `total`) values ('" + id_user + "','" + id_film + "','" + usuario + "','" + titulo.getText() + "','" + data_atual + "','" + data_devol_sql + "','" + cboPagamento.getSelectedItem() + "','" + valor.getText() + "');";
                con_cliente.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Aluguel realizado com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro no Aluguel :\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        //botão que irá alugar o filme no nome do usuário
        //INSERT
        
        //criando a variavel que conterá a faixa etaria do filme
        long faixa;
        
        //verificando se o filme possui classificação indicativa ou se é livre para todos os publicos
        if(classif.getText().equals("Livre")){
            faixa = 0;
        }else{
            faixa = Long.parseLong(classif.getText());
        }
        
        try{
            //verifica se uma opção de pagamento foi selecionada
            if(cboPagamento.getSelectedItem() != "..."){
                //mostra os detalhes do aluguel e pede confirmação
                int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirmar aluguel:\n\nFilme: " + titulo.getText() + "\nData para Devolução: " + data_devol + "\nValor: R$" + valor.getText() + "\nForma de Pagamento: " + cboPagamento.getSelectedItem() + "\n\nDeseja alugar?","Confirmação de Aluguel", JOptionPane.YES_NO_OPTION, 3);
                    
                if (resposta == 0){
                    //verificando se o usuário está dentro da faixa etária do filme
                    if(idade >= faixa){
                        try{
                            //verifica se o usuário já possui o filme alugado
                            String pesquisa = "select * from locacao where id_usuario = '" + id_user + "' && id_filme = " + id_film + "";
                            con_cliente.executaSQL(pesquisa);

                            if(con_cliente.resultset.first()){
                                JOptionPane.showMessageDialog(null, "Você já possui este filme alugado!\n\nVeja a locação no menu \"Filmes Alugados\"" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                //insere no banco a locação
                                try{
                                    insert();
                                    con_cliente.executaSQL("select * from filmes where `id` = " + id_film);
                                    posicionarRegistro();
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Não foi possível alugar o filme!\n\nTente novamente mais tarde!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                        catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Não foi possível verificar as suas locações!\n\nTente novamente mais tarde!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Você não possui idade suficiente para alugar este filme!\n\nVocê tem " + idade + " anos\n\nPara alugar este filme você precisa ter " + classif.getText() + " anos ou mais!","Informação",JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }else{
                    cboPagamento.setSelectedItem("...");
                }
                    
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
            }

        }
        catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível verificar as suas locações!\n\nTente novamente mais tarde!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //botão que fecha a janela e abre o catalogo
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JLabel classif;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel duracao;
    private javax.swing.JLabel genero;
    private javax.swing.JLabel imgFilm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lancamento;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDur;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblGenero1;
    private javax.swing.JLabel lblLanc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblpag;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel valor;
    // End of variables declaration//GEN-END:variables
}
