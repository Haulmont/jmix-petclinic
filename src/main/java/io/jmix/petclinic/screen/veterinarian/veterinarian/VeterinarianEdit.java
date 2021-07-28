package io.jmix.petclinic.screen.veterinarian.veterinarian;

import io.jmix.core.EntityStates;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.*;
import io.jmix.petclinic.entity.veterinarian.Veterinarian;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

@UiController("petclinic_Veterinarian.edit")
@UiDescriptor("veterinarian-edit.xml")
@EditedEntityContainer("veterinarianDc")
public class VeterinarianEdit extends StandardEditor<Veterinarian> {

    @Inject
    protected MessageBundle messageBundle;
    @Autowired
    private EntityStates entityStates;

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) {
        getWindow().setCaption(editorTitleLabel());
    }

    @NotNull
    private String editorTitleLabel() {
        if (entityStates.isNew(getEditedEntity())) {
            return messageBundle.getMessage("newCaption");
        }
        else {
            return messageBundle.formatMessage("editCaption", getEditedEntity().getName());
        }
    }

}