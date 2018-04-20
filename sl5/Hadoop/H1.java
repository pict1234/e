import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount{
	public static class TokenMapper extends Mapper<Object, Text, Text, IntWritable>
	{
		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();
		
		public void map(Object key,Text value,Context context) throws IOException, InterruptedException
		{
			StringTokenizer itr = new StringTokenizer(value.toString());
			while(itr.hasMoreTokens())
			{
				word.set(itr.nextToken());
				context.write(word, one);
			}
		}
		
	}
	
	public static class CountReducer extends Reducer<Text, IntWritable, Text, IntWritable>
	{
		private IntWritable result = new IntWritable();
		public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
		{
			int sum = 0;
			for(IntWritable val:values)
			{
				sum = sum + val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf,"word count");
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(TokenMapper.class);
		job.setCombinerClass(CountReducer.class);
		job.setReducerClass(CountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		Path out = new Path(args[1]);
		out.getFileSystem(conf).delete(out);
		job.waitForCompletion(true);
		
	}
}