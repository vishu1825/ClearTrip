package com.cleartrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;

	
	public static void launchApp() {
		
		try {
			prop = new Properties();
			System.out.println("Super Constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");			
			driver = new ChromeDriver(opt);
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		}
	
	/*@Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData1")
	public void verifyData(String str ,List<String> data) {
		assertUtil = new AssertionUtil();
		/*Iterator<String> it=data.keySet().iterator();
		while(it.hasNext()) {
			String cultureCD=it.next();
			List<String> value = data.get(cultureCD);*/
		
			for(String productCD :data) {
				try {
					List<Map> jobTitleData = DBHelper
							.getRows(SqlConstants.JOBTITLE_PRODUCT_MAPPING.replace("cultureCD", str));
					if (jobTitleData.size() > 0) {
						for (int i = 0; i < jobTitleData.size(); i++) {
							String jobTitle = jobTitleData.get(i).get("Title").toString();
								String url = URL.BASE_URL + CareerDomainConstants.V4_ADMIN_USER_JOBTITLES;
								ResponseBean resp = HttpService.get(url + "?SearchString=" + URLEncoder.encode(jobTitle, "UTF-8")
										+ "&AcceptLanguage=" + str + "&ProductCD=" + productCD + "&PortalCD=MPR"
										+ "&Placement=as&DocumentID=123&SearchType=TypeAhead", headers);
								if (resp.code == 200) {
									JSONObject respjson = new JSONObject(resp.message);
									String titleFromApi = respjson.getJSONArray("JobTitle").getJSONObject(0).get("Title")
											.toString();
									assertUtil.assertEquals(titleFromApi, jobTitle, "Title name from API & DB are not same");
								} else {
									assertUtil.fail("API response: " + resp.code + resp.message);

								}
						}

					}
				}

				catch (Exception e) {
					e.printStackTrace();
					assertUtil.fail(ExceptionUtils.getStackTrace(e));
				}
				assertUtil.assertAll();
			}*/
				
	/* @DataProvider(name="getData1")
	  public Object[][] getData1() {
		  Map<String,List<String>> map=new HashMap<>();
		  map.put("es-ES", Arrays.asList("RWZ","RSM","RB3","RB4","CSK","SKL"));
		  map.put("fr-FR", Arrays.asList("RWZ","RSM","RB3","RB4","CSK","SKL"));
		  map.put("de-DE", Arrays.asList("RWZ","RSM","RB4","CSK","SKL"));
		  map.put("it-IT", Arrays.asList("RWZ","RB4","CSK","SKL"));
		  map.put("pt-BR", Arrays.asList("RWZ","RB4","CSK","SKL"));
		  map.put("nl-NL", Arrays.asList("RWZ","RSM","RB3","RB4","CSK","SKL"));
		  map.put("pt-PT", Arrays.asList("RWZ","RSM","CSK"));
		  map.put("en-GB", Arrays.asList("RWZ","RSM","RB3","RB4","CSK","SKL"));
		  map.put("da-DK", Arrays.asList("RWZ","RSM","CSK"));
		  map.put("sv-SE", Arrays.asList("RWZ","RSM","CSK"));
		  map.put("es-MX", Arrays.asList("RWZ","RSM","CSK","RB3"));
		  map.put("en-US", Arrays.asList("RWZ","RSM","RB3","RB4","CSK","SKL","RBG"));
		  map.put("pl-PL", Arrays.asList("RSM","CSK","SKL"));
		  Iterator<String> it=map.keySet().iterator();
		  String cultureCD="";
			List<String> value=null;
			while(it.hasNext()) {
			cultureCD=it.next();
			value = map.get(cultureCD);
			}
		  return new Object[][] {
			  {cultureCD,value}
		  };
			
	  }*/
		
				
		
	}
	

	
}
