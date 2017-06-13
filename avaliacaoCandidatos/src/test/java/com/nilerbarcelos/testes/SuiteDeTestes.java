package com.nilerbarcelos.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nilerbarcelos.controller.CandidatoControllerTest;
import com.nilerbarcelos.email.EmailParserTest;

@RunWith(Suite.class)
@SuiteClasses({ EmailParserTest.class, CandidatoControllerTest.class })
public class SuiteDeTestes {

}
