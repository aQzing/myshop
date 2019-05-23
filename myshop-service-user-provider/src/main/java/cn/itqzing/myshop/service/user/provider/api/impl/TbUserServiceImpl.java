package cn.itqzing.myshop.service.user.provider.api.impl;

import cn.itqzing.myshop.commons.domain.TbUser;
import cn.itqzing.myshop.commons.mapper.TbUserMapper;
import cn.itqzing.shop.service.user.api.TbUserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectAll();
    }
}

