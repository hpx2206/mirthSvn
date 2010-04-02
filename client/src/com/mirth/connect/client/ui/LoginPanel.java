/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * http://www.mirthcorp.com
 *
 * The software in this package is published under the terms of the MPL
 * license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */

package com.mirth.connect.client.ui;

import java.awt.Cursor;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import com.mirth.connect.client.core.Client;
import com.mirth.connect.client.core.ClientException;
import com.mirth.connect.client.core.VersionMismatchException;
import com.mirth.connect.model.User;

public class LoginPanel extends javax.swing.JFrame {

    private Client client;

    public LoginPanel(String mirthServer, String version, String user, String pass) {
        PlatformUI.CLIENT_VERSION = version;
        initComponents();
        setTitle("Mirth Connect Administrator - Login");
        serverName.setText(mirthServer);
        jLabel2.setForeground(UIConstants.HEADER_TITLE_TEXT_COLOR);
        jLabel5.setForeground(UIConstants.HEADER_TITLE_TEXT_COLOR);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(com.mirth.connect.client.ui.Frame.class.getResource("images/mirth_32_ico.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        username.grabFocus();
        username.setText(user);
        password.setText(pass);
        errorPane.setVisible(false);

        mirthCorpImage.setIcon(UIConstants.MIRTHCORP_LOGO);
        mirthCorpImage.setText("");
        mirthCorpImage.setToolTipText(UIConstants.MIRTHCORP_TOOLTIP);
        mirthCorpImage.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mirthCorpImage.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BareBonesBrowserLaunch.openURL(UIConstants.MIRTHCORP_URL);
            }
        });

        mirthCorpImage1.setIcon(UIConstants.MIRTHCORP_LOGO);
        mirthCorpImage1.setText("");
        mirthCorpImage1.setToolTipText(UIConstants.MIRTHCORP_TOOLTIP);
        mirthCorpImage1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mirthCorpImage1.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BareBonesBrowserLaunch.openURL(UIConstants.MIRTHCORP_URL);
            }
        });

        if (user.length() > 0 && pass.length() > 0) {
            loginButtonActionPerformed(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        loginMain = new javax.swing.JPanel();
        errorPane = new javax.swing.JScrollPane();
        error = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        serverName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mirthHeadingPanel2 = new com.mirth.connect.client.ui.MirthHeadingPanel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        mirthCorpImage = new javax.swing.JLabel();
        loggingIn = new javax.swing.JPanel();
        mirthHeadingPanel1 = new com.mirth.connect.client.ui.MirthHeadingPanel();
        jLabel5 = new javax.swing.JLabel();
        loginProgress = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        mirthCorpImage1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mirth Connect Administrator Login");
        setResizable(false);

        loginMain.setBackground(new java.awt.Color(255, 255, 255));
        loginMain.setName(""); // NOI18N

        errorPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        errorPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        error.setBackground(java.awt.Color.pink);
        error.setColumns(20);
        error.setEditable(false);
        error.setFont(new java.awt.Font("Tahoma", 0, 11));
        error.setRows(3);
        error.setText("There was a problem authenticating the information that\nwas entered.  Please verify that the server is up and \nrunning and that the user information is valid.");
        error.setAutoscrolls(false);
        error.setFocusable(false);
        errorPane.setViewportView(error);

        closeButton.setText("Exit");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        serverName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Server:");

        jLabel3.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mirth Connect Administrator Login");

        javax.swing.GroupLayout mirthHeadingPanel2Layout = new javax.swing.GroupLayout(mirthHeadingPanel2);
        mirthHeadingPanel2.setLayout(mirthHeadingPanel2Layout);
        mirthHeadingPanel2Layout.setHorizontalGroup(
            mirthHeadingPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        mirthHeadingPanel2Layout.setVerticalGroup(
            mirthHeadingPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel6.setText("Password:");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        mirthCorpImage.setText(" ");

        javax.swing.GroupLayout loginMainLayout = new javax.swing.GroupLayout(loginMain);
        loginMain.setLayout(loginMainLayout);
        loginMainLayout.setHorizontalGroup(
            loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addGroup(loginMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serverName, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                .addGap(52, 52, 52))
            .addComponent(mirthHeadingPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mirthCorpImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );

        loginMainLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {closeButton, loginButton});

        loginMainLayout.setVerticalGroup(
            loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainLayout.createSequentialGroup()
                .addComponent(mirthHeadingPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(serverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorPane, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(loginButton)
                    .addComponent(mirthCorpImage))
                .addContainerGap())
        );

        loggingIn.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mirth Connect Administrator Login");

        javax.swing.GroupLayout mirthHeadingPanel1Layout = new javax.swing.GroupLayout(mirthHeadingPanel1);
        mirthHeadingPanel1.setLayout(mirthHeadingPanel1Layout);
        mirthHeadingPanel1Layout.setHorizontalGroup(
            mirthHeadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        mirthHeadingPanel1Layout.setVerticalGroup(
            mirthHeadingPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mirthHeadingPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginProgress.setDoubleBuffered(true);

        status.setText("Please wait: Logging in...");

        mirthCorpImage1.setText(" ");

        javax.swing.GroupLayout loggingInLayout = new javax.swing.GroupLayout(loggingIn);
        loggingIn.setLayout(loggingInLayout);
        loggingInLayout.setHorizontalGroup(
            loggingInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mirthHeadingPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loggingInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(loggingInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(status)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(loggingInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(loggingInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mirthCorpImage1)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        loggingInLayout.setVerticalGroup(
            loggingInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loggingInLayout.createSequentialGroup()
                .addComponent(mirthHeadingPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(mirthCorpImage1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loggingIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loggingIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_usernameActionPerformed
    {// GEN-HEADEREND:event_usernameActionPerformed
        loginButtonActionPerformed(null);
    }// GEN-LAST:event_usernameActionPerformed

    private void serverNameActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_serverNameActionPerformed
    {// GEN-HEADEREND:event_serverNameActionPerformed
        loginButtonActionPerformed(null);
    }// GEN-LAST:event_serverNameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_passwordActionPerformed
    {// GEN-HEADEREND:event_passwordActionPerformed
        loginButtonActionPerformed(null);
    }// GEN-LAST:event_passwordActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_loginButtonActionPerformed
    {// GEN-HEADEREND:event_loginButtonActionPerformed
        errorPane.setVisible(false);

        final LoginPanel thisPanel = this;

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

            public Void doInBackground() {
                try {
                    if (login()) {
                        setStatus("Authenticated...");
                        new Mirth(client);
                        thisPanel.dispose();

                        try {
                            Properties serverProperties = client.getServerProperties();
                            String registered = serverProperties.getProperty("firstlogin");
                            if (registered == null || registered.equals(UIConstants.YES_OPTION)) {
                                User currentUser = PlatformUI.MIRTH_FRAME.getCurrentUser(PlatformUI.MIRTH_FRAME);

                                if (currentUser != null) {
                                    new FirstLoginDialog(currentUser);
                                }
                            }
                        } catch (ClientException e) {
                            PlatformUI.MIRTH_FRAME.alertException(PlatformUI.MIRTH_FRAME, e.getStackTrace(), e.getMessage());
                        }

                        PlatformUI.MIRTH_FRAME.checkForUpdates();
                        PlatformUI.MIRTH_FRAME.sendUsageStatistics();
                    } else {
                        errorPane.setVisible(true);
                        loggingIn.setVisible(false);
                        loginMain.setVisible(true);
                        loginProgress.setIndeterminate(false);
                        password.grabFocus();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            public void done() {
            }
        };
        worker.execute();

        loggingIn.setVisible(true);
        loginMain.setVisible(false);
        loginProgress.setIndeterminate(true);
    }// GEN-LAST:event_loginButtonActionPerformed

    /**
     * If the button is "Next" instead of "Finish" then it moves on to the next
     * options. Otherwise, it creates the new channel.
     */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_closeButtonActionPerformed
    {// GEN-HEADEREND:event_closeButtonActionPerformed
        this.dispose();
        System.exit(0);
    }// GEN-LAST:event_closeButtonActionPerformed

    private boolean login() {
        try {
            String server = serverName.getText();
            client = new Client(server);
            PlatformUI.SERVER_NAME = server;
            if (client.login(username.getText(), String.valueOf(password.getPassword()), PlatformUI.CLIENT_VERSION)) {
                PlatformUI.USER_NAME = username.getText();
                return true;
            } else {
                error.setText("There was a problem authenticating the information that\nwas entered.  Please verify that the server is up and \nrunning and that the user information is valid.");
            }
        } catch (ClientException ex) {
            if (ex.getCause() instanceof VersionMismatchException) {
                error.setText("The version of this client does not match the version\nof the server.  Please clear your Java cache and\nrelaunch the client from the server webpage.");
            } else {
                error.setText("There was a problem authenticating the information that\nwas entered.  Please verify that the server is up and \nrunning and that the user information is valid.");
            }
        }
        return false;
    }

    public void setStatus(String status) {
        this.status.setText("Please wait: " + status);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea error;
    private javax.swing.JScrollPane errorPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loggingIn;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginMain;
    private javax.swing.JProgressBar loginProgress;
    private javax.swing.JLabel mirthCorpImage;
    private javax.swing.JLabel mirthCorpImage1;
    private com.mirth.connect.client.ui.MirthHeadingPanel mirthHeadingPanel1;
    private com.mirth.connect.client.ui.MirthHeadingPanel mirthHeadingPanel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField serverName;
    private javax.swing.JLabel status;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
