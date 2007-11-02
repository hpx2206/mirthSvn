/*
 * MessageBrowserAdvancedFilter.java
 *
 * Created on November 1, 2007, 4:35 PM
 */

package com.webreach.mirth.client.ui.browsers.message;

/**
 *
 * @author  chrisr
 */
public class MessageBrowserAdvancedFilter extends javax.swing.JDialog {
    
    /** Creates new form MessageBrowserAdvancedFilter */
    public MessageBrowserAdvancedFilter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        connectorField = new com.webreach.mirth.client.ui.components.MirthTextField();
        jLabel4 = new javax.swing.JLabel();
        messageTypeField = new com.webreach.mirth.client.ui.components.MirthTextField();
        jLabel7 = new javax.swing.JLabel();
        messageSourceField = new com.webreach.mirth.client.ui.components.MirthTextField();
        jLabel10 = new javax.swing.JLabel();
        containing = new com.webreach.mirth.client.ui.components.MirthTextField();
        jLabel9 = new javax.swing.JLabel();
        rawMessageCheckBox = new com.webreach.mirth.client.ui.components.MirthCheckBox();
        transformedMessageCheckBox = new com.webreach.mirth.client.ui.components.MirthCheckBox();
        encodedMessageCheckBox = new com.webreach.mirth.client.ui.components.MirthCheckBox();
        jLabel5 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        protocolComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.white);
        jLabel1.setText("Connector:");

        jLabel4.setText("Message Type:");

        jLabel7.setText("Source:");

        jLabel10.setText("Containing:");

        jLabel9.setText(" in ");

        rawMessageCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        rawMessageCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rawMessageCheckBox.setText("Raw");
        rawMessageCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        transformedMessageCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        transformedMessageCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        transformedMessageCheckBox.setText("Transformed");
        transformedMessageCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        encodedMessageCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        encodedMessageCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        encodedMessageCheckBox.setText("Encoded");
        encodedMessageCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel5.setText("Status:");

        jLabel8.setText("Protocol:");

        protocolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("OK");
        jButton1.setMaximumSize(new java.awt.Dimension(65, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(65, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(65, 23));

        jButton2.setText("Cancel");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel10)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(messageSourceField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(messageTypeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(containing, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel9))
                            .add(connectorField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel8)
                                    .add(jLabel5))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(protocolComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(statusComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .add(rawMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(transformedMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(encodedMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(connectorField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(statusComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(messageTypeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(messageSourceField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel8)
                        .add(protocolComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(containing, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(rawMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(transformedMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(encodedMessageCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageBrowserAdvancedFilter(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.webreach.mirth.client.ui.components.MirthTextField connectorField;
    private com.webreach.mirth.client.ui.components.MirthTextField containing;
    private com.webreach.mirth.client.ui.components.MirthCheckBox encodedMessageCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.webreach.mirth.client.ui.components.MirthTextField messageSourceField;
    private com.webreach.mirth.client.ui.components.MirthTextField messageTypeField;
    private javax.swing.JComboBox protocolComboBox;
    private com.webreach.mirth.client.ui.components.MirthCheckBox rawMessageCheckBox;
    private javax.swing.JComboBox statusComboBox;
    private com.webreach.mirth.client.ui.components.MirthCheckBox transformedMessageCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
