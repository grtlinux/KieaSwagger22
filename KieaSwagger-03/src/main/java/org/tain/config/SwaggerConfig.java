package org.tain.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

	@Bean
	public Docket swaggerApi00() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())	// api, basic-error, main (controller), Models
				//.apis(RequestHandlerSelectors.basePackage("org.tain.controller"))
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/v1/*"))  // main-controller
				.build()
				.apiInfo(swaggerApiInfo())
				.useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, new ArrayList<>(Arrays.asList(
					new ResponseBuilder().code("403").description("Forbidden!!!!!").build(),
					new ResponseBuilder().code("500").description("500 message").build()
				)))
				//.securitySchemes(Arrays.asList(securityScheme()))
				//.securityContexts(Arrays.asList(securityContext()))
		;
	}
	
	private ApiInfo swaggerApiInfo() {
		return new ApiInfo(
				"My REST API",
				"Some custom description of API.",
				"API TOS",
				"Terms of service",
				new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
				"License of API",
				"API license",
				Collections.emptyList()
				);
	}
	
	/*
	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
			.clientId(CLIENT_ID)
			.clientSecret(CLIENT_SECRET)
			.scopeSeparator(" ")
			.useBasicAuthenticationWithAccessCodeGrant(true)
			.build();
	}
	
	private SecurityScheme securityScheme() {
		GrantType grantType = new AuthorizationCodeGrantBuilder()
			.tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
			.tokenRequestEndpoint(
			  new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
			.build();

		SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
			.grantTypes(Arrays.asList(grantType))
			.scopes(Arrays.asList(scopes()))
			.build();
		return oauth;
	}
	
	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = { 
		  new AuthorizationScope("read", "for read operations"), 
		  new AuthorizationScope("write", "for write operations"), 
		  new AuthorizationScope("foo", "Access foo API") };
		return scopes;
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder()
		  .securityReferences(
			Arrays.asList(new SecurityReference("spring_oauth", scopes())))
		  .forPaths(PathSelectors.regex("/foos.*"))
		  .build();
	}
	*/
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	private final String version = "v1";
	
	//@Bean
	public Docket swaggerApi01() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(version)
				.apiInfo(this.swaggerApiInfo01())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.tain"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo swaggerApiInfo01() {
		return new ApiInfoBuilder()
				.title("Example API")
				.description("Swagger ????????? ?????? example")
				.build();
	}
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	//@Bean
	public Docket swaggerApi02() {
		return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(ApiIgnore.class)
				.apiInfo(this.swaggerApiInfo02()).select()
				.apis(RequestHandlerSelectors.basePackage("org.tain"))
				.build()
				.useDefaultResponseMessages(false);
	}
	
	private ApiInfo swaggerApiInfo02() {
		return new ApiInfoBuilder().title("API Documentation")
				.description("??????????????? API ??????")
				.license("license : ???????????????").licenseUrl("http://idc.tainweb.com/").build();
	}
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	private static final String API_NAME = "Swagger Study API";
	private static final String API_VERSION = "0.0.1";
	private static final String API_DESCRIPTION = "???????????? API ?????????";

	
	/**
	 * Swagger??? ???????????? ?????? ?????? ??????(Docket) ??????
	 * 
	 * apiInfo: ?????? ???????????? ?????? API ?????? ??????
	 * apis:  api ????????? ???????????? ?????? ?????????(Controller) ??????
	 * paths: ????????? ???, ?????? ????????? ?????? ????????? ?????? ?????? (PathSelectors.any() = ????????? ???, ?????? ????????? ?????? ????????? ??????)

	 * @return Docket
	 */
	//@Bean
	public Docket swaggerApi03() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.groupName(API_VERSION)	   // API_VERSION = "0.0.1";
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.tain"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.swaggerApiInfo03());
	}
	
	
	/**
	 * API ?????? ?????? ??????
	 * 
	 * title: API ??????
	 * version: API ?????? ??????
	 * description: API description
	 * 
	 * @return ApiInfo
	 */
	public ApiInfo swaggerApiInfo03() {
		return new ApiInfoBuilder()
				.title(API_NAME)				// API_NAME = "Swagger Study API";
				.version(API_VERSION)			// API_VERSION = "0.0.1";
				.description(API_DESCRIPTION)	// API_DESCRIPTION = "???????????? API ?????????";
				.build();

	}
}
