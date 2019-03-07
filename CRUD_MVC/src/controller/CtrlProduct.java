package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Product;
import model.QueryProducts;
import view.frmProduct;

/**
 * Class that contains the functionalities of the buttons of the application.
 */
public class CtrlProduct implements ActionListener {

	private Product product;
	private QueryProducts qProducts;
	private frmProduct frmProduct;

	public CtrlProduct(Product product, QueryProducts qProducts, frmProduct frmProduct) {
		this.product = product;
		this.qProducts = qProducts;
		this.frmProduct = frmProduct;

		this.frmProduct.getBtnSave().addActionListener(this);
		this.frmProduct.getBtnEdit().addActionListener(this);
		this.frmProduct.getBtnDelete().addActionListener(this);
		this.frmProduct.getBtnClean().addActionListener(this);
		this.frmProduct.getBtnSearch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Function for the "Save" button.
		if (e.getSource() == frmProduct.getBtnSave()) {
			product.setCode(frmProduct.getTextCode().getText());
			product.setName(frmProduct.getTextName().getText());
			product.setPrice(Double.parseDouble(frmProduct.getTextPrice().getText()));
			product.setQuantity(Integer.parseInt(frmProduct.getTextQuantity().getText()));

			if (qProducts.Insert(product)) {
				JOptionPane.showMessageDialog(null, "Record saved correctly");

				CleanForm();
			} else {
				JOptionPane.showMessageDialog(null, "Error saving the record");

				CleanForm();
			}
		}

		// Function for the "Edit" button.
		if (e.getSource() == frmProduct.getBtnEdit()) {
			product.setId(Integer.parseInt(frmProduct.getTextId().getText()));
			product.setCode(frmProduct.getTextCode().getText());
			product.setName(frmProduct.getTextName().getText());
			product.setPrice(Double.parseDouble(frmProduct.getTextPrice().getText()));
			product.setQuantity(Integer.parseInt(frmProduct.getTextQuantity().getText()));

			if (qProducts.Update(product)) {
				JOptionPane.showMessageDialog(null, "Record edited correctly");

				CleanForm();
			} else {
				JOptionPane.showMessageDialog(null, "Error editing the record");

				CleanForm();
			}
		}

		// Function for the "Delete" button.
		if (e.getSource() == frmProduct.getBtnDelete()) {
			product.setId(Integer.parseInt(frmProduct.getTextId().getText()));

			if (qProducts.Delete(product)) {
				JOptionPane.showMessageDialog(null, "Record eliminated correctly");

				CleanForm();
			} else {
				JOptionPane.showMessageDialog(null, "Error deleting the record");

				CleanForm();
			}
		}

		// Function for the "Search" button.
		if (e.getSource() == frmProduct.getBtnSearch()) {
			product.setCode(frmProduct.getTextCode().getText());

			if (qProducts.Search(product)) {
				frmProduct.getTextId().setText(String.valueOf(product.getId()));
				frmProduct.getTextCode().setText(product.getCode());
				frmProduct.getTextName().setText(product.getName());
				frmProduct.getTextPrice().setText(String.valueOf(product.getPrice()));
				frmProduct.getTextQuantity().setText(String.valueOf(product.getQuantity()));
			} else {
				JOptionPane.showMessageDialog(null, "Error showing the record");

				CleanForm();
			}
		}

		// Function for the "Clean" button.
		if (e.getSource() == frmProduct.getBtnClean()) {
			CleanForm();
		}

	}

	// Method that changes the name of the application and makes the ID
	// field invisible.
	public void Start() {
		frmProduct.setTitle("CRUD MVC");
		frmProduct.getTextId().setVisible(false);
	}

	// Clean the form fields. 
	public void CleanForm() {
		frmProduct.getTextId().setText(null);
		frmProduct.getTextCode().setText(null);
		frmProduct.getTextName().setText(null);
		frmProduct.getTextPrice().setText(null);
		frmProduct.getTextQuantity().setText(null);
	}

}
