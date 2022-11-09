package org.myorg;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TopCategoryMapper extends Mapper<LongWritable, Text, Text, Text> {
	      private Text category = new Text();
	      private Text views = new Text();
	      public void map(LongWritable key, Text value, Context context )
	        throws IOException, InterruptedException {
	           String line = value.toString();
	           String str[]=line.split("\t");
	          if(str.length > 2){
	                category.set(str[3]);
	                views.set(value);
	          }
	      context.write(category, views);
	}
}