/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exp.visitor;

import javax.ejb.Remote;

/**
 *
 * @author sohel
 */
@Remote
public interface VisitorCountExampleRemote {

    int countVisitor(int value);
    
}
