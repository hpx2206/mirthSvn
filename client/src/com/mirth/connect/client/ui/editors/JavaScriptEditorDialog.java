/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * http://www.mirthcorp.com
 *
 * The software in this package is published under the terms of the MPL
 * license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */

package com.mirth.connect.client.ui.editors;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JDialog;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.EvaluatorException;
import org.syntax.jedit.SyntaxDocument;
import org.syntax.jedit.tokenmarker.JavaScriptTokenMarker;

import com.mirth.connect.client.ui.Frame;
import com.mirth.connect.client.ui.PlatformUI;
import com.mirth.connect.client.ui.util.FileUtil;

public class JavaScriptEditorDialog extends javax.swing.JDialog implements DropTargetListener {

    private Frame parent;
    private String savedScript;

    public JavaScriptEditorDialog(String script) {
        super(PlatformUI.MIRTH_FRAME, true);
        initialize(script);
    }

    public JavaScriptEditorDialog(java.awt.Frame owner, String script) {
        super(owner, true);
        initialize(script);
    }

    public JavaScriptEditorDialog(Dialog owner, String script) {
        super(owner, true);
        initialize(script);
    }

    private void initialize(String script) {
        this.parent = PlatformUI.MIRTH_FRAME;
        initComponents();
        SyntaxDocument doc = new SyntaxDocument();
        doc.setTokenMarker(new JavaScriptTokenMarker());
        scriptContent.setDocument(doc);
        setSavedScript(script);
        scriptContent.setCaretPosition(0);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                cancelButtonActionPerformed(null);
            }
        });

        pack();
        new DropTarget(scriptContent, this);
        Dimension dlgSize = getPreferredSize();
        Dimension frmSize = parent.getSize();
        Point loc = parent.getLocation();

        if ((frmSize.width == 0 && frmSize.height == 0) || (loc.x == 0 && loc.y == 0)) {
            setLocationRelativeTo(null);
        } else {
            setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        }

        setVisible(true);
    }

    public String getSavedScript() {
        return savedScript;
    }

    public void setSavedScript(String script) {
        scriptContent.setText(script);
        savedScript = script;
    }

    public void dragEnter(DropTargetDragEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);

                java.util.List fileList = (java.util.List) tr.getTransferData(DataFlavor.javaFileListFlavor);
                Iterator iterator = fileList.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
            } else {
                dtde.rejectDrag();
            }
        } catch (Exception e) {
            dtde.rejectDrag();
        }
    }

    public void dragOver(DropTargetDragEvent dtde) {
    }

    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    public void dragExit(DropTargetEvent dte) {
    }

    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            if (tr.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {

                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

                java.util.List fileList = (java.util.List) tr.getTransferData(DataFlavor.javaFileListFlavor);
                Iterator iterator = fileList.iterator();
                while (iterator.hasNext()) {
                    File file = (File) iterator.next();

                    scriptContent.setText(scriptContent.getText() + FileUtil.read(file));
                }
            }
        } catch (Exception e) {
            dtde.rejectDrop();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        validateScriptButton = new javax.swing.JButton();
        scriptContent = new com.mirth.connect.client.ui.components.MirthSyntaxTextArea();
        openFileButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Script");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Close this message sender dialog.");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        validateScriptButton.setText("Validate Script");
        validateScriptButton.setToolTipText("Process the message displayed in the editor above.");
        validateScriptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateScriptButtonActionPerformed(evt);
            }
        });

        scriptContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        openFileButton.setText("Open File...");
        openFileButton.setToolTipText("Open a file into the editor above.");
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setToolTipText("Close this message sender dialog.");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(openFileButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validateScriptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(scriptContent, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scriptContent, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(validateScriptButton)
                    .addComponent(openFileButton)
                    .addComponent(okButton))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
// TODO add your handling code here:
        File importFile = parent.importFile(null);

        if (importFile != null) {
            try {
                scriptContent.setText(FileUtil.read(importFile));
            } catch (IOException e) {
                parent.alertError(this, "Unable to read file.");
            }
        }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

private void validateScriptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateScriptButtonActionPerformed
    StringBuilder sb = new StringBuilder();
    Context context = Context.enter();
    try {
        context.compileString("function rhinoWrapper() {" + scriptContent.getText() + "\n}", PlatformUI.MIRTH_FRAME.mirthClient.getGuid(), 1, null);
        sb.append("JavaScript was successfully validated.");
    } catch (EvaluatorException e) {
        sb.append("Error on line " + e.lineNumber() + ": " + e.getMessage() + " of the current script.");
    } catch (Exception e) {
        sb.append("Unknown error occurred during validation.");
    }

    Context.exit();

    parent.alertInformation(this, sb.toString());
}//GEN-LAST:event_validateScriptButtonActionPerformed

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    savedScript = scriptContent.getText();
    this.dispose();
}//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton openFileButton;
    private com.mirth.connect.client.ui.components.MirthSyntaxTextArea scriptContent;
    private javax.swing.JButton validateScriptButton;
    // End of variables declaration//GEN-END:variables
}
