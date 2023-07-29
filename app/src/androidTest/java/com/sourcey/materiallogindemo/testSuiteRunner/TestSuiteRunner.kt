package com.sourcey.materiallogindemo.testSuiteRunner

import com.sourcey.materiallogindemo.uitests.InvalidLoginTests
import com.sourcey.materiallogindemo.uitests.ValidLoginTests
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    ValidLoginTests::class,
    InvalidLoginTests::class
)

class TestSuiteRunner