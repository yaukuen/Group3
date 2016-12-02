package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import request.Request;
import request.RequestCollection;

/**
 * This class creates the GUI for viewing all of the student requests
 * and delete the request after updating the student's employment information of that request.
 * @author Loc Bui
 *
 */
public class ViewRequestGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8173105788916568140L;
	private static final int TABLE_WIDTH = 1100;
	private static final int TABLE_HEIGHT = 550;
	
	private JButton myBtnView, myBtnDelete;
	private JPanel myBtnPanel;
	private List<Request> myList;
	private Object[][] myData;
	private Object[] mItemColumnNames = {"SID: ", "Name", "Comment", "RequestID"};
	private Container myPnlContent;
	private TableModel myTableModel;
	private JTable myTable;
	private JScrollPane myScrollPane;

	/**
	 * The constructor to call the method to create all of the components
	 */
	public ViewRequestGUI() {
		setLayout(new BorderLayout());
		myList = getData();
		createComponents();
		setVisible(true);
	}
	
	public List<Request> getData() {
		myList = RequestCollection.showTheList();

		if (myList != null) {
			myData = new Object[myList.size()][mItemColumnNames .length];
			for (int i = 0; i < myList.size(); i++) {
				myData[i][0] = myList.get(i).getMySid();
				myData[i][1] = myList.get(i).getMyName();
				myData[i][2] = myList.get(i).getMyContent();
				myData[i][3] = myList.get(i).getMyRequestId();
			}
		}
		return myList;
	}
	
	/**
	 * This method creates the panel for viewing all of the request
	 * and delete button for deleting request after updating.
	 */
	private void createComponents() {
		myPnlContent = new JPanel();
		myBtnView = new JButton("View all request");
		myBtnView.addActionListener(this);
		myBtnDelete = new JButton("Delete request");
		myBtnDelete.setEnabled(false);
		myBtnDelete.addActionListener(this);
		
		createListPanel();
		
		myBtnPanel = new JPanel();
		myBtnPanel.add(myBtnView);
		myBtnPanel.add(myBtnDelete);
		add(myBtnPanel, BorderLayout.NORTH);
		add(myPnlContent, BorderLayout.CENTER);
	}
	
	public void createListPanel() {
		myList = getData();
		if(myList.size() == 0) {
			myBtnDelete.setEnabled(false);
		} else {
			myBtnDelete.setEnabled(true);
		}
		myTableModel = new DefaultTableModel(myData, mItemColumnNames);
		myTable = new JTable(myTableModel);
		myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		int commentColumnWidth = 872;
		myTable.getColumnModel().getColumn(2).setPreferredWidth(commentColumnWidth);
		myScrollPane = new JScrollPane(myTable);
		myScrollPane.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		myPnlContent.add(myScrollPane);
	}

	/**
	 * Make the buttons work!
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == myBtnView) {
			myList = getData();
			if(myList.size() == 0) {
				myBtnDelete.setEnabled(false);
			} else {
				myBtnDelete.setEnabled(true);
			}
			myPnlContent.removeAll();
			createListPanel();
			myPnlContent.revalidate();
			myPnlContent.setVisible(true);
			this.repaint();
		} else if (e.getSource() == myBtnDelete) {
			myList = getData();
			if(myList.size() == 0) {
        		JOptionPane.showMessageDialog(null, "Nothing to delete!", 
        				null , JOptionPane.INFORMATION_MESSAGE);
				myBtnDelete.setEnabled(false);
			} else {
				myBtnDelete.setEnabled(true);
				int viewIndex = myTable.getSelectedRow();
				if (viewIndex != -1) {
					int changableColumn = 3;
					int modelIndex = myTable.convertRowIndexToModel(viewIndex);
			        DefaultTableModel model = (DefaultTableModel)myTable.getModel();
			        model.removeRow(modelIndex);
			        String id = (String) myData[viewIndex][changableColumn];
			        RequestCollection.removeRequest(id);
				}
			}
		}
	}
}
