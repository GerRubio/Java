package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlProduct;
import model.Product;
import model.QueryProducts;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Class that contains all the elements of the graphical application.
 */
public class frmProduct extends JFrame {

	private JPanel content;

	// Text Fields.
	private JTextField textCode;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textQuantity;
	private JTextField textId;

	// Buttons.
	private JButton btnSave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnClean;
	private JButton btnSearch;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					frmProduct frmProduct = new frmProduct();
					Product product = new Product();
					QueryProducts qProducts = new QueryProducts();
					CtrlProduct ctrlProduct = new CtrlProduct(product, qProducts, frmProduct);

					// Call the method that changes the name of the application and makes the ID
					// field invisible.
					ctrlProduct.Start();

					frmProduct.setVisible(true);
				} catch (Exception exception) {
					System.out.println(exception);
				}

			}

		});

	}

	public frmProduct() {
		setResizable(false);
		setTitle("CRUD MVC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 210);

		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		content.setLayout(null);
		setContentPane(content);

		// Labels.
		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(30, 30, 50, 14);
		content.add(lblCode);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(29, 55, 50, 14);
		content.add(lblName);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(30, 80, 50, 14);
		content.add(lblPrice);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(29, 105, 50, 14);
		content.add(lblQuantity);

		textId = new JTextField();
		textId.setBounds(304, 52, 89, 20);
		content.add(textId);
		textId.setColumns(10);

		textCode = new JTextField();
		textCode.setBounds(109, 27, 185, 20);
		content.add(textCode);
		textCode.setColumns(10);

		textName = new JTextField();
		textName.setBounds(109, 52, 185, 20);
		content.add(textName);
		textName.setColumns(10);

		textPrice = new JTextField();
		textPrice.setBounds(109, 77, 185, 20);
		content.add(textPrice);
		textPrice.setColumns(10);

		textQuantity = new JTextField();
		textQuantity.setBounds(109, 102, 185, 20);
		content.add(textQuantity);
		textQuantity.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(10, 145, 89, 23);
		content.add(btnSave);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(109, 145, 89, 23);
		content.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(205, 145, 89, 23);
		content.add(btnDelete);

		btnClean = new JButton("Clean");
		btnClean.setBounds(304, 145, 89, 23);
		content.add(btnClean);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(304, 25, 89, 23);
		content.add(btnSearch);
	}

	// Getters and Setters.
	public JTextField getTextCode() {
		return textCode;
	}

	public void setTextCode(JTextField textCode) {
		this.textCode = textCode;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextPrice() {
		return textPrice;
	}

	public void setTextPrice(JTextField textPrice) {
		this.textPrice = textPrice;
	}

	public JTextField getTextQuantity() {
		return textQuantity;
	}

	public void setTextQuantity(JTextField textQuantity) {
		this.textQuantity = textQuantity;
	}

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnClean() {
		return btnClean;
	}

	public void setBtnClean(JButton btnClean) {
		this.btnClean = btnClean;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

}
