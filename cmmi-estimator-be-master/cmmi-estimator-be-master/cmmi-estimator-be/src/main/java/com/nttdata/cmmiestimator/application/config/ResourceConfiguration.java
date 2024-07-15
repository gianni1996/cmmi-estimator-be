package com.nttdata.cmmiestimator.application.config;

//@Configuration
//@PropertySource("classpath:application.properties")
//@EnableWebSecurity
//@EnableResourceServer
//public class ResourceConfiguration extends ResourceServerConfigurerAdapter {

//    private final static String CLIENT_ID = "prova";
//
//    private final static String SECRET = "prova";
//
//    @Value("${ntt.authorization.endpoint}")
//    private String authEndpoint;
//
//    @Primary
//    @Bean
//    public RemoteTokenServices tokenService() {
//
//        RemoteTokenServices tokenService = new RemoteTokenServices();
//        tokenService.setCheckTokenEndpointUrl(this.authEndpoint);
//        tokenService.setClientId(CLIENT_ID);
//        tokenService.setClientSecret(SECRET);
//        return tokenService;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//    	   String[] unauthorizedRequests = new String[] { "/resources/openapi/**" };
//           http.csrf().disable().anonymous().and().authorizeRequests().antMatchers(unauthorizedRequests).permitAll().anyRequest().authenticated();
//    }

//}
