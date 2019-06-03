package com.mcserby.training.api;

import com.mcserby.training.ConversionEngine;
import com.mcserby.training.SyntaxParser;
import com.mcserby.training.UnitConverter4;
import com.mcserby.training.exception.ConversionFailedException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by mserban on 03.05.2018.
 */
@Controller
public class ConverterApiController implements ConverterApi {


    private final ConversionEngine conversionEngine;

    @Autowired
    public ConverterApiController() {
        SyntaxParser syntaxParser = new SyntaxParser();
        UnitConverter4 unitConverter = new UnitConverter4();
        conversionEngine = new ConversionEngine(syntaxParser, unitConverter);
    }

    @Override
    public ResponseEntity<String> convert(@ApiParam(value = "conversion phrase", required = true) @Valid
                                          @RequestBody String phrase) {
        try {
            return ResponseEntity.ok("" + this.conversionEngine.convert(phrase).getValue());
        } catch (ConversionFailedException e) {
            return ResponseEntity.status(500).body("Conversion failed");
        }
    }

    @Override
    public ResponseEntity<String> convert2(@ApiParam(value = "conversion phrase", required = true) @Valid
                                               @RequestParam("phrase") String phrase) {
        try {
            return ResponseEntity.ok("" + this.conversionEngine.convert(phrase).getValue());
        } catch (ConversionFailedException e) {
            return ResponseEntity.status(500).body("Conversion failed");
        }
    }
}
