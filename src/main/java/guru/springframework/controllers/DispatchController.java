package guru.springframework.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import guru.springframework.domain.Dispatch;

@RestController
@RequestMapping("/dispatch")
@Api(value="dispatch", description="Add new Dispatch")
public class DispatchController {

    @ApiOperation(value = "Add a Dispatch")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveDispatch(@RequestBody Dispatch dispatch){
    	 RestTemplate restTemplate = new RestTemplate(); 
    	 
    	 
    	 MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
    	 
    	 header.add("username", "test");
    	 header.add("password", "test");
    	 header.add("Content-Type", "application/json");
    	 
    	 HttpEntity<Dispatch> request = new HttpEntity<>(dispatch, header);
    	 restTemplate.postForEntity("API URL", request, Dispatch.class);
    	
        return new ResponseEntity<String>("Dispatch saved successfully", HttpStatus.OK);
    }

   

}
