package com.vilin.mybatis.chapter09.mapper;

import com.vilin.mybatis.chapter09.pojo.TFile;

public interface TFileMapper {
    public int insertTFile(TFile tFile);

    public TFile getTFile(Long i);
}
