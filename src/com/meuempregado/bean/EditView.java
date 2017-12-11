package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.meuempregado.model.Ponto;
import com.meuempregado.service.PontoService;
 
@ManagedBean(name="dtEditView")
@ViewScoped
public class EditView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = -5445893098287341838L;

	private List<Ponto> ponto;
    
 
    public List<Ponto> getPonto() {
        return ponto;
    }
 
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Horario Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}