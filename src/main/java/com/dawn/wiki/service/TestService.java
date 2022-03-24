package com.dawn.wiki.service;

import com.dawn.wiki.domain.Test;
import com.dawn.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    // 也可以用@Autowired
    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.list();
    }
}
