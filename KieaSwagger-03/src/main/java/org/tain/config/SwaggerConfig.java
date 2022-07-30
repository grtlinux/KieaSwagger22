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
				.description("Swagger 소개를 위한 example")
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
				.description("제주들려섬 API 문서")
				.license("license : 제주들렸섬").licenseUrl("http://idc.tainweb.com/").build();
	}
	
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	private static final String API_NAME = "Swagger Study API";
	private static final String API_VERSION = "0.0.1";
	private static final String API_DESCRIPTION = "사칙연산 API 명세서";

	
	/**
	 * Swagger를 사용하기 위한 핵심 객체(Docket) 생성
	 * 
	 * apiInfo: 현재 등록하려 하는 API 명세 정보
	 * apis:  api 스펙이 작성되어 있는 패키지(Controller) 지정
	 * paths: 패키지 내, 특정 경로를 추가 세팅할 경우 사용 (PathSelectors.any() = 패키지 내, 전체 경로에 대해 문서화 진행)

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
	 * API 문서 정보 설정
	 * 
	 * title: API 이름
	 * version: API 명세 버전
	 * description: API description
	 * 
	 * @return ApiInfo
	 */
	public ApiInfo swaggerApiInfo03() {
		return new ApiInfoBuilder()
				.title(API_NAME)				// API_NAME = "Swagger Study API";
				.version(API_VERSION)			// API_VERSION = "0.0.1";
				.description(API_DESCRIPTION)	// API_DESCRIPTION = "사칙연산 API 명세서";
				.build();

	}
}
