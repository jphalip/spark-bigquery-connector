package com.google.cloud.spark.bigquery.pushdowns

import com.google.cloud.spark.bigquery.direct.BigQueryRDDFactory
import org.apache.spark.sql.execution.SparkPlan

class Spark24PlanFactory extends SparkPlanFactory {
  /**
   * Generate SparkPlan from the output and RDD of the translated query
   */
  override def createBigQueryPlan(queryRoot: BigQuerySQLQuery, bigQueryRDDFactory: BigQueryRDDFactory): Option[SparkPlan] = {
    Some(Spark24BigQueryPushdownPlan(queryRoot.output, bigQueryRDDFactory.buildScanFromSQL(queryRoot.getStatement().toString)))
  }
}
