package com.mcserby.training.api;

/**
 * Interface for smartSIS swxDataQuery
 * Created by MSerban on 26.04.2018.
 */

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Api(value = "converterApi", description = "API for Unit converter")
public interface ConverterApi {

    @ApiOperation(value = "Converts units given a phrase", notes = "Converter",
            response = String.class, tags = {"Converter"})
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server error", response = Void.class), @ApiResponse
            (code = 200, message = "status", response = String.class)})

    @RequestMapping(value = "/convert", produces = {"text/plain"}, method = RequestMethod.POST)
    ResponseEntity<String> convert(@ApiParam(value = "conversion phrase", required = true) @Valid
                                   @RequestBody String phrase);


    @ApiOperation(value = "Converts units given a phrase", notes = "Converter",
            response = String.class, tags = {"Converter"})
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Server error", response = Void.class), @ApiResponse
            (code = 200, message = "status", response = String.class)})

    @RequestMapping(value = "/convert2", produces = {"text/plain"}, method = RequestMethod.GET)
    ResponseEntity<String> convert2(@ApiParam(value = "conversion phrase", required = true) @Valid
                                    @RequestParam("phrase") String phrase);

}
