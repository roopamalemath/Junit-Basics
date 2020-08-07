# Junit-Basics

Annotations
@Test
@DisplayName
@Nested
@Tag("Math")



LifeCycle hooks
@BeforeAll
@BeforeEach
@AfterEach
@AfterAll

Junit Providers and Dependency Injection
TestInfo testInfo;
TestReporter testReporter

and we can also create own custom providers.

Single Instance Per Test class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

Single Instance Per Test Method
@TestInstance(TestInstance.Lifecycle.PER_METHOD)

RepetitionInfo repetationInfo - passing as the method argument
following with annotation @RepeatedTest(3)

@EnabledOnOs(OS.LINUX) - runs test only LINUX Operating system
@EnabledOnOs(OS.WINDOWS) - runs test only WINDOWS Operating system
@EnableIf
@EnableIfSystemProperty 
@EnableIfEnvironmentVaraible - run only dev environment, prod environment

Assertions
assertEquals(expected,actual,String)
assertEquals(expected,actual)
assertEquals(expected,actual,()->String)
assertTrue
assertArraysEquals
assertThrows(expected, ()->actual) - when the method throwing an expecting purposefully


 

