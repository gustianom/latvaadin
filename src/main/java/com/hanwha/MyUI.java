package com.hanwha;

import javax.servlet.annotation.WebServlet;

import com.hanwha.bean.contract.ContractMasterHelper;
import com.hanwha.model.ContractMasterModel;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.HashMap;
import java.util.List;

/**
 * hanwha
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private ContractMasterModel contractMasterModel;

    private Grid grid = new Grid();
    private TextField name = new TextField("Name");
    private TextField website = new TextField("Website;");
    private Button save = new Button("Save");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        updateGrid();
        grid.addSelectionListener(new SelectionEvent.SelectionListener() {
            @Override
            public void select(SelectionEvent selectionEvent) {
                updateForm();
            }
        });

        VerticalLayout layout = new VerticalLayout(
                grid, name, website, save);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

    private void updateGrid() {
//        ContractMasterHelper helper = new ContractMasterHelper();
//        List<ContractMasterModel> companies = helper.getListRenderer(new HashMap(), false );
//        grid.setContainerDataSource(
//                new BeanItemContainer(ContractMasterModel.class, companies));
        setFormVisible(false);
    }

    private void updateForm() {
        setFormVisible(!grid.getSelectedRows().isEmpty());
        if (!grid.getSelectedRows().isEmpty()) {
            contractMasterModel = (ContractMasterModel) grid.getSelectedRow();
            BeanFieldGroup.bindFieldsUnbuffered(contractMasterModel, this);
        }
    }

    private void setFormVisible(boolean visible) {
        name.setVisible(visible);
        website.setVisible(visible);
        save.setVisible(visible);
    }


    @WebServlet(value = {"/main/*", "/VAADIN/*"}, name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
