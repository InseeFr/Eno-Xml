package fr.insee.eno.ws.controller;

import fr.insee.eno.parameters.Context;
import fr.insee.eno.parameters.Mode;
import fr.insee.eno.parameters.OutFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametersFileNameTest {

    @Test
    void businessCAWIXformsCase() {
        // Given
        Context context = Context.BUSINESS;
        Mode mode = Mode.CAWI;
        OutFormat outFormat = OutFormat.XFORMS;
        // When + Then
        assertEquals("eno-parameters-BUSINESS-CAWI-XFORMS.xml",
                ParametersController.parametersFileName(context, mode, outFormat));
    }

    @Test
    void defaultDDI_nullMode() {
        // Given
        Context context = Context.DEFAULT;
        OutFormat outFormat = OutFormat.DDI;
        // When + Then
        assertEquals("eno-parameters-DEFAULT-DDI.xml",
                ParametersController.parametersFileName(context, null, outFormat));
    }

}
