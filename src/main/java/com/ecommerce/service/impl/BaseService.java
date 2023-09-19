package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.dao.AccountDAO;
import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.ProductDAO;

import lombok.Getter;
import lombok.Setter;

/**
 * @Project: hn-naitei19-02-ecommerce
 * @Author: sonle
 * @Date: 15/09/2023
 * @Time: 15:33
 */
@Getter
@Setter
public abstract class BaseService {
    @Autowired
    protected AccountDAO accountDAO;
    @Autowired
    protected OrderDAO orderDAO;
    @Autowired
    protected ProductDAO productDAO;
}
