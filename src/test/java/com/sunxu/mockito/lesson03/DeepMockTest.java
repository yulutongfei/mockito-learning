package com.sunxu.mockito.lesson03;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/11/3 07:22
 */
public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;
    @Mock
    private Lesson03 lesson03;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepMock() {
        Lesson03 lesson03 = lesson03Service.get();
        lesson03.foo();
    }
}
