/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014 The Billing Project, LLC
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.plugin.analytics.dao.model;

import org.killbill.billing.plugin.analytics.AnalyticsTestSuiteNoDB;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBusinessInvoiceModelDao extends AnalyticsTestSuiteNoDB {

    @Test(groups = "fast")
    public void testConstructor() throws Exception {
        final BusinessInvoiceModelDao invoiceModelDao = new BusinessInvoiceModelDao(account,
                                                                                    accountRecordId,
                                                                                    invoice,
                                                                                    invoiceRecordId,
                                                                                    currencyConverter,
                                                                                    auditLog,
                                                                                    tenantRecordId,
                                                                                    reportGroup);

        verifyBusinessModelDaoBase(invoiceModelDao, accountRecordId, tenantRecordId);
        Assert.assertEquals(invoiceModelDao.getCreatedDate(), invoice.getCreatedDate());
        Assert.assertEquals(invoiceModelDao.getInvoiceRecordId(), invoiceRecordId);
        Assert.assertEquals(invoiceModelDao.getInvoiceId(), invoice.getId());
        Assert.assertEquals(invoiceModelDao.getInvoiceNumber(), invoice.getInvoiceNumber());
        Assert.assertEquals(invoiceModelDao.getInvoiceDate(), invoice.getInvoiceDate());
        Assert.assertEquals(invoiceModelDao.getTargetDate(), invoice.getTargetDate());
        Assert.assertEquals(invoiceModelDao.getCurrency(), invoice.getCurrency().toString());
        Assert.assertEquals(invoiceModelDao.getBalance(), invoice.getBalance());
        Assert.assertEquals(invoiceModelDao.getAmountPaid(), invoice.getPaidAmount());
        Assert.assertEquals(invoiceModelDao.getAmountCharged(), invoice.getChargedAmount());
        Assert.assertEquals(invoiceModelDao.getOriginalAmountCharged(), invoice.getOriginalChargedAmount());
        Assert.assertEquals(invoiceModelDao.getAmountCredited(), invoice.getCreditedAmount());
        Assert.assertEquals(invoiceModelDao.getAmountRefunded(), invoice.getRefundedAmount());
    }
}
