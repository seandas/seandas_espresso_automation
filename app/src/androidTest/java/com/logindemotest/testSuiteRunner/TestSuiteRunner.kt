package com.logindemotest.testSuiteRunner

import com.logindemotest.uitests.InvalidLoginTests
import com.logindemotest.uitests.ValidLoginTests
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    ValidLoginTests::class,
    InvalidLoginTests::class
)

class TestSuiteRunner